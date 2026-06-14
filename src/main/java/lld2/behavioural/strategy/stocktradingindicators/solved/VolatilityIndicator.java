package lld2.behavioural.strategy.stocktradingindicators.solved;

public class VolatilityIndicator implements TradingIndicatorStrategy{
    @Override
    public TradingStrategyType supportsType() {
        return TradingStrategyType.VOLATILITY;
    }

    @Override
    public Double calculateIndicator(Stock stock) {
        return Math.abs(stock.getPrice() - stock.getPreviousPrice());
    }
}
