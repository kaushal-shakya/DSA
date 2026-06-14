package lld2.behavioural.strategy.stocktradingindicators.solved;

public interface TradingIndicatorStrategy {
    TradingStrategyType supportsType();
    Double calculateIndicator(Stock stock);
}
