package ch.bdt.spike.spring.cloud.portfolioservice.api;

import ch.bdt.spike.spring.cloud.stockservice.api.StockPrice;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PositionValue {
    private StockPrice unitPrice;

    private int count;

    private double value;

    public PositionValue(StockPrice unitPrice, int count) {
        this.unitPrice = unitPrice;
        this.count = count;
        this.value = unitPrice.getPrice() * count;
    }

}
