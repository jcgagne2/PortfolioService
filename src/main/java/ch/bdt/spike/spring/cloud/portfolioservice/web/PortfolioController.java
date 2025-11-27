package ch.bdt.spike.spring.cloud.portfolioservice.web;

import ch.bdt.spike.spring.cloud.currencyconverter.api.PriceWithCurrency;
import ch.bdt.spike.spring.cloud.portfolioservice.api.Portfolio;
import ch.bdt.spike.spring.cloud.portfolioservice.api.PositionValue;
import ch.bdt.spike.spring.cloud.portfolioservice.service.ICurrencyConverterClient;
import ch.bdt.spike.spring.cloud.portfolioservice.service.IStockServiceClient;
import ch.bdt.spike.spring.cloud.stockservice.api.StockPrice;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PortfolioController {
    private final Portfolio portfolio = new Portfolio();
    @Resource
    private IStockServiceClient stockServiceClient;

    @Resource
    private ICurrencyConverterClient currencyConverterClient;

    @PostConstruct
    public void init() {
        // On initie le portefeuille avec quelques actions au démarrage
        log.info("initializing portfolio");
        portfolio.addPosition("AAPL", 10);
        portfolio.addPosition("MSFT", 5);
        portfolio.addPosition("GOOG", 2);
    }

    @GetMapping("/getPortfolio")
    public Portfolio getPortfolio() {
        return portfolio;
    }

    @GetMapping("/getPositionValue")
    public PositionValue getPositionValue(String symbol, @RequestParam(defaultValue = "USD") String currency) {
        log.info("getPositionValue {} {}", symbol, currency);
        // Le nombre d'actions
        Integer vCount = portfolio.getPositionCount(symbol);
        // Le prix de l'action. En USD par défaut
        StockPrice vStockPrice = stockServiceClient.getStockPrice(symbol);
        // Conversion si currency différente
        if (!currency.equals(vStockPrice.getCurrency())) {
            PriceWithCurrency vPriceWithCurrency = currencyConverterClient.convert(vStockPrice.getPrice(),
                                                                                   vStockPrice.getCurrency(),
                                                                                   currency);
            vStockPrice = new StockPrice(vStockPrice.getSymbol(),
                                         vPriceWithCurrency.getPrice(),
                                         vPriceWithCurrency.getCurrency());
        }
        return new PositionValue(vStockPrice, vCount);
    }

    @GetMapping("/buyPosition")
    public StockPrice buyPosition(String symbol, int amount) {
        portfolio.addPosition(symbol, amount);
        // Le prix de l'action. En USD par défaut
        StockPrice vStockPrice = stockServiceClient.getStockPrice(symbol);
        return new StockPrice(symbol, vStockPrice.getPrice(), vStockPrice.getCurrency());
    }

    @GetMapping("/sellPosition")
    public StockPrice sellPosition(String symbol, int amount) {
        portfolio.removePosition(symbol, amount);
        // Le prix de l'action. En USD par défaut
        StockPrice vStockPrice = stockServiceClient.getStockPrice(symbol);
        return new StockPrice(symbol, vStockPrice.getPrice(), vStockPrice.getCurrency());
    }
}
