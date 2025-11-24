package ch.bdt.spike.spring.cloud.currencyconverter.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ICurrencyConverter {
    @GetMapping(path = "/convert")
    PriceWithCurrency convert(@RequestParam double amount, @RequestParam String fromCurrency, @RequestParam String toCurrency);

}
