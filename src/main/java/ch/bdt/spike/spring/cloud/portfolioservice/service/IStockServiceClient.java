package ch.bdt.spike.spring.cloud.portfolioservice.service;

import ch.bdt.spike.spring.cloud.stockservice.api.IStockService;
import org.springframework.cloud.openfeign.FeignClient;

//
/**
 En mode normal, on doit définir l'url dans le fichier de config :

spring:
  cloud:
    discovery:
      client:
        simple:
          instances:
            # On peut aussi déclarer ici les URLs des remote services
            StockService:
              - uri: http://localhost:8080


 En mode discovery, doit correspondre au nom sous lequel le service s'est enregistré
*/
@FeignClient(name = "StockService")
// On peut aussi mettre l'url ici
// @FeignClient(name = "StockService", url = "http://localhost:8080")
public interface IStockServiceClient extends IStockService {
}
