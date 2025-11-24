package ch.bdt.spike.spring.cloud.portfolioservice.api;


import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private final Map<String, Integer> positions = new HashMap<>();

    public Map<String, Integer> getPositions() {
        return positions;
    }

    public Integer getPositionCount(String symbol) {
        return positions.get(symbol);
    }

    public Integer addPosition(String symbol, Integer count) {
        positions.compute(symbol, (k, v) -> v == null ? count : v + count);
        return positions.get(symbol);
    }

    public Integer removePosition(String symbol, Integer count) {
        positions.compute(symbol, (k, v) -> v == null ? count : v - count);
        return positions.get(symbol);
    }
}
