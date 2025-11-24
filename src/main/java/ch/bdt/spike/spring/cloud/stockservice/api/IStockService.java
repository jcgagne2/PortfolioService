package ch.bdt.spike.spring.cloud.stockservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Devrait être dans un package à part.
 */
public interface IStockService {
    @GetMapping(path = "/getStockPrice")
    public StockPrice getStockPrice(@RequestParam(required = true) String symbol);
}
