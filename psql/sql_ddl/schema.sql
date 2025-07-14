-- psql -h PSQL_HOST -p 5432 -U postgres postgres -f schema.sql

DROP TABLE IF EXISTS sta.stocks cascade;

CREATE SCHEMA sta;

CREATE TABLE sta.stocks (
	id SERIAL PRIMARY KEY,
	symbol VARCHAR(10) UNIQUE NOT NULL,
	price DOUBLE PRECISION NOT NULL,
	"timestamp" TIMESTAMP DEFAULT (timezone('utc', now()))
)

INSERT INTO sta.stocks (symbol, price) VALUES ('AAPL', 175.50);
INSERT INTO sta.stocks (symbol, price) VALUES ('GOOGL', 340.71);
INSERT INTO sta.stocks (symbol, price) VALUES ('AMZN', 33.00);

CREATE OR REPLACE VIEW sta.most_requested
AS
SELECT *
FROM sta.stocks
ORDER BY timestamp DESC
LIMIT 3;