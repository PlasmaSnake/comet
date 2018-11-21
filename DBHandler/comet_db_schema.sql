CREATE TABLE Accounts(
account_id NUMERIC GENERATED ALWAYS AS IDENTITY( START WITH 10000 INCREMENT BY 1) NOT NULL,
username VARCHAR2(20) NOT NULL UNIQUE,
pass VARCHAR2(20) NOT NULL,
email VARCHAR2(30) NOT NULL UNIQUE,
full_name VARCHAR2(30),
country VARCHAR(20),
CONSTRAINT account_id_pk PRIMARY KEY(account_id)
);

CREATE TABLE coinbasicinfo(
coin_id NUMERIC GENERATED ALWAYS AS IDENTITY( START WITH 1 INCREMENT BY 1) NOT NULL,
symbol varchar(5) UNIQUE NOT NULL,
coin_name varchar(20) UNIQUE NOT NULL,
max_supply DECIMAL(10,4) NOT NULL,
CONSTRAINT coin_id_pk PRIMARY KEY(coin_id)
);

CREATE TABLE usercoins(
user_id NUMERIC UNIQUE NOT NULL,
coin_id NUMERIC UNIQUE NOT NULL,
CONSTRAINT user_id_fk FOREIGN KEY(user_id) REFERENCES accounts(account_id),
CONSTRAINT coin_id_fk FOREIGN KEY(coin_id) REFERENCES coinbasicinfo(coin_id)
);

CREATE TABLE coinhistoricalinfo(
coin_id NUMERIC UNIQUE NOT NULL,
coin_timestamp NUMERIC NOT NULL,
open_price DECIMAL(10,2) NOT NULL,
close_price DECIMAL(10,2) NOT NULL,
high_price DECIMAL(10,2) NOT NULL,
low_price DECIMAL(10,2) NOT NULL,
volumeTo NUMERIC NOT NULL,
volumeFrom NUMERIC NOT NULL,
total_supply NUMERIC,
CONSTRAINT coin_id_historical_fk FOREIGN KEY(coin_id) REFERENCES coinbasicinfo(coin_id)
);

COMMIT;