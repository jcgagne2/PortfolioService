package ch.bdt.spike.spring.cloud.stockservice.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Devrait être dans un package à part.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockPrice {
    private String symbol;
    private double price;
    private String currency;

}
