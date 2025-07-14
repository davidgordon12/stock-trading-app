package com.davidgordon.stock_trading_server.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "stocks", schema = "sta")
public class Stock {
    @Id
    @GeneratedValue
    private Integer id;

    private String symbol;

    private double price;

    private Timestamp timestamp;

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
