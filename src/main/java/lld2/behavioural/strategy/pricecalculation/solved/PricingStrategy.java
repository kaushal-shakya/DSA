package lld2.behavioural.strategy.pricecalculation.solved;

public interface PricingStrategy {
    PricingType supportsType();
    Double calculatePrice(RideDetails rideDetails);
}
