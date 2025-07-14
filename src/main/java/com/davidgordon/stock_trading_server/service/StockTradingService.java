package com.davidgordon.stock_trading_server.service;

import com.davidgordon.grpc.StockRequest;
import com.davidgordon.grpc.StockResponse;
import com.davidgordon.stock_trading_server.model.Stock;
import com.davidgordon.stock_trading_server.repository.StockRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;
import com.davidgordon.grpc.StockTradingServiceGrpc;

@GrpcService
public class StockTradingService extends StockTradingServiceGrpc.StockTradingServiceImplBase {
    private StockRepository stockRepository;

    public StockTradingService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public void getStockPrice(StockRequest request, StreamObserver<StockResponse> responseObserver) {
        String symbol = request.getSymbol();

        Stock stock = stockRepository.findBySymbol(symbol);

        // Map our Stock model to our gRPC StockResponse type
        StockResponse response = StockResponse.newBuilder()
                .setSymbol(stock.getSymbol())
                .setPrice(stock.getPrice())
                .setTimestamp(stock.getTimestamp().toString())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
