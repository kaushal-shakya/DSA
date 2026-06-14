package lld2.behavioural.strategy.mapsnavigation;

/**
 * CarPathCalculator — Concrete Strategy for car navigation.
 *
 * Implements the PathCalculator strategy for car-based travel.
 * Cars use highways and main roads, avoid narrow lanes, and
 * factor in traffic conditions for ETA calculation.
 */
public class CarPathCalculator implements PathCalculator {

    @Override
    public String findPath(String source, String destination) {
        // In a real application, this would use a graph algorithm
        // optimized for car routes (highways, main roads, traffic signals)
        System.out.println("  [Car Strategy] Calculating car route...");
        System.out.println("  → Preferring highways and main roads");
        System.out.println("  → Avoiding narrow lanes and pedestrian zones");
        System.out.println("  → Factoring in real-time traffic");
        return "Car path from " + source + " to " + destination
                + " via Highway → Main Road → Destination (ETA: 25 mins)";
    }
}
