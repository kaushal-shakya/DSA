package lld2.behavioural.strategy.stocktradingindicators.solved;

public class MomentumIndicator implements TradingIndicatorStrategy {
    @Override
    public TradingStrategyType supportsType() {
        return TradingStrategyType.MOMENTUM;
    }

    @Override
    public Double calculateIndicator(Stock stock) {
        return stock.getPrice() - stock.getPreviousPrice();
    }
}
