package lld2.behavioural.strategy.mapsnavigation;

/**
 * GoogleMaps — Context class that uses the Strategy pattern.
 *
 * Instead of having a giant if-else block to handle different
 * transport modes, GoogleMaps delegates pathfinding to the
 * appropriate PathCalculator strategy obtained from the factory.
 *
 * This class is now:
 * ✅ Open-Closed Principle compliant — add new modes without modifying this class
 * ✅ Single Responsibility — only orchestrates, doesn't implement algorithms
 */
public class GoogleMaps {

    /**
     * Finds the path between source and destination for the given transport mode.
     *
     * @param source      the starting location
     * @param destination the ending location
     * @param mode        the transport mode ("car", "bike", or "walk")
     * @return the calculated path description with ETA
     */
    public String findPath(String source, String destination, String mode) {
        PathCalculator pathCalculator = PathCalculatorFactory.getPathCalculator(mode);
        return pathCalculator.findPath(source, destination);
    }
}
