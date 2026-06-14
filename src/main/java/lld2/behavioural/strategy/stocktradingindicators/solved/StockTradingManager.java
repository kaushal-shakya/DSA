package lld2.behavioural.strategy.stocktradingindicators.solved;

public class StockTradingManager {

    private TradingStrategyType strategyType;
    private TradingIndicatorStrategy tradingIndicatorStrategy;

    public StockTradingManager(TradingStrategyType strategyType, TradingIndicatorStrategy tradingIndicatorStrategy) {
        this.strategyType = strategyType;
        this.tradingIndicatorStrategy = tradingIndicatorStrategy;
    }

    public Double calculateIndicator(Stock stock) {
        return tradingIndicatorStrategy.calculateIndicator(stock);
    }
}
