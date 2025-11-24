package ch.bdt.spike.spring.cloud.portfolioservice.service;

import ch.bdt.spike.spring.cloud.currencyconverter.api.ICurrencyConverter;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "CurrencyConverter")
//@FeignClient(name = "currency-converter", url = "http://localhost:8081")
public interface ICurrencyConverterClient extends ICurrencyConverter {
}
