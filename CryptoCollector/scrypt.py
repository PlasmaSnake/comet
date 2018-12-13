#! python3.6
# scrypt.py - Queries the CRYPTOCOMPARE API using a package by lagerfeuer
# Scripted by Michael Matthew Sy 'github.com/PlasmaSnake'
# Currently outputs to Data and replaces BTCHistDaily.
# Meant to only be run one time for each Coin.
# 

from datetime import datetime
import time
from threading import Timer
from urllib.request import urlopen
import json
import requests
import os

ts = time.time()

## This API call only receives the following Data in USD:
## time: UNIX time
## close: Closing price in .2f format
## high: highest price
## low: lowest price
## open: Opening price
## volumefrom: Volume from BTC to USD traded (ex: 33000 coins were traded into USD)
## volumeto: Volume to USD from BTC (ex: 20 mil USD were traded into BTC)

## TODO:
## refine script so it stops when it gets to a response with each argument as 0 
## 
##
timesRan = 0;
lastKnownTime = 0;
lastKnownResponse = "";

def cryptocompareRequest(coin): # Change coin symbol to retrieve a different coin
	# Queries from current time to last recorded time from responses
	if timesRan < 1 : 
		queryCoin(coin, int(ts))
	else :
		queryCoin(coin, lastKnownTime)

def queryCoin(coin, queryTime):
	url = urlopen('https://min-api.cryptocompare.com/data/histoday?fsym='+coin+'&tsym=USD&limit=500&toTs='+str(queryTime)+'&extraParams=COMETCOINAPP')
	resp = json.loads(url.read().decode('utf-8'))
	dirPath = os.path.join(os.path.abspath(os.path.dirname(__file__)), 'data', coin)
	lastKnownResponse = os.path.join(dirPath, coin+'HistDaily'+str(timesRan)+'.json')

	try :
	# create target directory(ies)
		os.makedirs(dirPath)
	except FileExistsError:
		pass

	with open(lastKnownResponse, 'w') as outfile:
		json.dump(resp, outfile)
	# records the time of query and inserts for the next one
	readLastTimeOfQuery(coin)


## Reads JSON response from cyptocompare and if returns true, stop the script.
## returns true if values are 0
def endOfRequest(coin):
	dirPath = os.path.join(os.path.abspath(os.path.dirname(__file__)), 'data', coin)
	lastKnownResponse = os.path.join(dirPath, coin+'HistDaily'+str(timesRan)+'.json')
	with open(lastKnownResponse, 'r') as data:
		data = json.load(data)
	if ( ## simple checker for 
		data["Data"][0]['close'] == 0 and data["Data"][0]['high'] == 0 and
		data["Data"][0]['low'] == 0 and data["Data"][0]['open'] == 0
		):
		return True
	else:
		increment() ## increments timesRan for next request
		return False

## Reads the first element of JSON response for the time for next queryCoin
def readLastTimeOfQuery(coin):
	dirPath = os.path.join(os.path.abspath(os.path.dirname(__file__)), 'data', coin)
	lastKnownResponse = os.path.join(dirPath, coin+'HistDaily'+str(timesRan)+'.json')
	with open(lastKnownResponse, 'r') as readfile:
		data = json.load(readfile)
	global lastKnownTime
	lastKnownTime = int(data["Data"][0]['time'])

def increment():
	global timesRan
	timesRan += 1

def cryptocompareCoinToUSDRequest(coin):
	url = urlopen('https://min-api.cryptocompare.com/data/pricemultifull?fsyms='+coin+'&tsyms=USD&extraParams=COMETCOINAPP')
	# change to get basic info
	resp = json.loads(url.read().decode('utf-8'))
	dirPath = os.path.join(os.path.abspath(os.path.dirname(__file__)), 'data', coin)
	filePath = os.path.join(dirPath, coin+'ToUSDInfo.json')
	try :
	# create target directory(ies)
		os.makedirs(dirPath)
	except FileExistsError:
		pass

	with open(filePath, 'w') as outfile:
		json.dump(resp, outfile)

def cryptocompareAllCoinRequest():
	url = urlopen('https://min-api.cryptocompare.com/data/all/coinlist')
	resp = json.loads(url.read().decode('utf-8'))
	dirPath = os.path.join(os.path.abspath(os.path.dirname(__file__)), 'data')
	filePath = os.path.join(dirPath, 'AllCoins.json')
	try :
	# create target directory(ies)
		os.makedirs(dirPath)
	except FileExistsError:
		pass

	with open(filePath, 'w') as outfile:
		json.dump(resp, outfile)

cryptocompareAllCoinRequest()
# coin = 'ETH'
# cryptocompareCoinToUSDRequest(coin)
# cryptocompareRequest(coin)
# while not endOfRequest(coin):
# 	cryptocompareRequest(coin)