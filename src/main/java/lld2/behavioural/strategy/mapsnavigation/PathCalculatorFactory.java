package lld2.behavioural.strategy.mapsnavigation;

/**
 * PathCalculatorFactory — Factory + Singleton for creating PathCalculator instances.
 *
 * Merges two design patterns:
 * 1. Factory — creates the correct PathCalculator based on the mode
 * 2. Singleton — each PathCalculator instance is created once and reused
 *
 * This factory eliminates the if-else chain from the client code (GoogleMaps)
 * and centralizes object creation in one place.
 */
public class PathCalculatorFactory {
    private static final CarPathCalculator CAR_PATH_CALCULATOR = new CarPathCalculator();
    private static final BikePathCalculator BIKE_PATH_CALCULATOR = new BikePathCalculator();
    private static final WalkPathCalculator WALK_PATH_CALCULATOR = new WalkPathCalculator();

    public static PathCalculator getPathCalculator(String mode) {
        return switch (mode.toLowerCase()) {
            case "car" -> CAR_PATH_CALCULATOR;
            case "bike" -> BIKE_PATH_CALCULATOR;
            case "walk" -> WALK_PATH_CALCULATOR;
            default -> throw new RuntimeException("mode is invalid");
        };
    }
}