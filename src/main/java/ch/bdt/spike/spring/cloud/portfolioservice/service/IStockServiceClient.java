package ch.bdt.spike.spring.cloud.portfolioservice.service;

import ch.bdt.spike.spring.cloud.stockservice.api.IStockService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "StockService")
public interface IStockServiceClient extends IStockService {
}
