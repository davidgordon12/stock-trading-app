package com.davidgordon.stock_trading_server.repository;

import com.davidgordon.stock_trading_server.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    Stock findBySymbol(String stockSymbol);
}
