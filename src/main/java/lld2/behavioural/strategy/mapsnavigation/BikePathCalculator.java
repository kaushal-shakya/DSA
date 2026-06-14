package lld2.behavioural.strategy.mapsnavigation;

/**
 * BikePathCalculator — Concrete Strategy for bike navigation.
 *
 * Implements the PathCalculator strategy for bike-based travel.
 * Bikes can take shortcuts and smaller roads that cars cannot,
 * but avoid highways and high-speed zones.
 */
public class BikePathCalculator implements PathCalculator {

    @Override
    public String findPath(String source, String destination) {
        // In a real application, this would use a graph algorithm
        // optimized for bike routes (shortcuts, smaller roads)
        System.out.println("  [Bike Strategy] Calculating bike route...");
        System.out.println("  → Using shortcuts and inner roads");
        System.out.println("  → Avoiding highways and high-speed zones");
        System.out.println("  → Factoring in lane-splitting opportunities");
        return "Bike path from " + source + " to " + destination
                + " via Inner Road → Shortcut → Destination (ETA: 18 mins)";
    }
}