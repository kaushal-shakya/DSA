package lld2.behavioural.strategy.mapsnavigation;

/**
 * WalkPathCalculator — Concrete Strategy for walking navigation.
 *
 * Implements the PathCalculator strategy for pedestrian travel.
 * Walkers can take narrow alleys, staircases, pedestrian paths,
 * and footbridges that vehicles cannot access.
 */
public class WalkPathCalculator implements PathCalculator {

    @Override
    public String findPath(String source, String destination) {
        // In a real application, this would use a graph algorithm
        // optimized for pedestrian routes (footpaths, alleys, stairs)
        System.out.println("  [Walk Strategy] Calculating walking route...");
        System.out.println("  → Using footpaths and narrow alleys");
        System.out.println("  → Including staircases and pedestrian bridges");
        System.out.println("  → Taking the most direct route possible");
        return "Walking path from " + source + " to " + destination
                + " via Footpath → Alley → Pedestrian Bridge → Destination (ETA: 45 mins)";
    }
}