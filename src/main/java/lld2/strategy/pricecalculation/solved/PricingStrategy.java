package lld2.strategy.pricecalculation.solved;

public interface PricingStrategy {
    PricingType supportsType();
    Double calculatePrice(RideDetails rideDetails);
}
