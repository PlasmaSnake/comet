#! python3.6
# scrypt.py - Queries the CRYPTOCOMPARE API using a package by lagerfeuer
# Scripted by Michael Matthew Sy 'github.com/PlasmaSnake'
# Currently outputs to Data and replaces BTCHistDaily.
# Meant to only be run one time.

from datetime import datetime
import time
from threading import Timer
from urllib.request import urlopen
import json
import requests
import os
import sched
import cryptocompare

s=sched.scheduler(time.time, time.sleep)
ts = time.time()

## This API call only receives the following Data in USD:
## time: UNIX time
## close: Closing price in .2f format
## high: highest price
## low: lowest price
## open: Opening price
## volumefrom: Volume from BTC to USD traded (ex: 33000 coins were traded into USD)
## volumeto: Volume to USD from BTC (ex: 20 mil USD were traded into BTC)

def queryCoin(coin, queryTime):
#BTC
	url = urlopen('https://min-api.cryptocompare.com/data/histoday?fsym='+coin+'&tsym=USD&limit=2000&toTs='+str(queryTime)+'&extraParams=COMETCOINAPP')
	resp = json.loads(url.read().decode('utf-8'))
	with open(os.path.join('c:\home\comet\cryptocollector\data','BTCHistDaily'+'.txt'), 'w') as outfile:
		json.dump(resp, outfile)

def queryCoinFrom2013(coin):
#BTC
	url = urlopen('https://min-api.cryptocompare.com/data/histoday?fsym='+coin+'&tsym=USD&limit=1100&toTs=1368540000&extraParams=COMETCOINAPP')
	resp = json.loads(url.read().decode('utf-8'))
	with open(os.path.join('c:\home\comet\cryptocollector\data','BTCHistDaily-May14_2013'+'.txt'), 'w') as outfile:
		json.dump(resp, outfile)

def cryptocompareRequest():
	# Queries from current time
	queryCoin('BTC', int(ts));
	# Queries from May 14 2013
	queryCoinFrom2013('BTC');


s.enter(1, 1, cryptocompareRequest, ())
s.run()