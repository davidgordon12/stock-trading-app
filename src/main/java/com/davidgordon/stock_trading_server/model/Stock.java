package com.davidgordon.stock_trading_server.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "sta.stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "symbol")
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
