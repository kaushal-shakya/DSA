package lld2.strategy.pricecalculation.solved;

public class PricingManager {

    private PricingType pricingType;
    private PricingStrategy strategy ;
    public PricingManager(PricingType pricingType, PricingStrategy strategy) {
        this.pricingType = pricingType;
        this.strategy = strategy;

    }

    public Double calculatePrice(RideDetails rideDetails) {
        return strategy.calculatePrice(rideDetails);
    }
}
