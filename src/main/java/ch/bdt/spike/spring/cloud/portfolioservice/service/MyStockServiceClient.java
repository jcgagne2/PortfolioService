package ch.bdt.spike.spring.cloud.portfolioservice.service;

import ch.bdt.spike.spring.cloud.stockservice.api.StockPrice;
import io.micrometer.observation.annotation.Observed;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MyStockServiceClient {
    @Resource
    private IStockServiceClient stockServiceClient;

    @Observed(
            name = "my getStockPrice",
            contextualName = "MyStockServiceClient.getStockPrice",
            lowCardinalityKeyValues = {"class.name", "MyStockServiceClient"}
    )
    public StockPrice getStockPrice(String symbol) {
        return stockServiceClient.getStockPrice(symbol);
    }
}
