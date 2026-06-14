package lld2.strategy.mapsnavigation;

/**
 * Client — Runnable demo for the Strategy Design Pattern.
 *
 * Demonstrates:
 * 1. Using GoogleMaps with different transport modes
 * 2. How the Strategy pattern eliminates if-else chains
 * 3. How Factory + Singleton patterns work together with Strategy
 * 4. How adding a new mode requires ZERO changes to existing code
 */
public class Client {

    public static void main(String[] args) {

        GoogleMaps maps = new GoogleMaps();

        System.out.println("════════════════════════════════════════");
        System.out.println("  DEMO 1: Strategy Pattern — Car Mode");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        String carPath = maps.findPath("Koramangala", "Whitefield", "car");
        System.out.println();
        System.out.println("  Result: " + carPath);

        System.out.println();
        System.out.println("════════════════════════════════════════");
        System.out.println("  DEMO 2: Strategy Pattern — Bike Mode");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        String bikePath = maps.findPath("Koramangala", "Whitefield", "bike");
        System.out.println();
        System.out.println("  Result: " + bikePath);

        System.out.println();
        System.out.println("════════════════════════════════════════");
        System.out.println("  DEMO 3: Strategy Pattern — Walk Mode");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        String walkPath = maps.findPath("Koramangala", "Whitefield", "walk");
        System.out.println();
        System.out.println("  Result: " + walkPath);

        System.out.println();
        System.out.println("════════════════════════════════════════");
        System.out.println("  DEMO 4: Same Interface, Different Strategy");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        // The beauty of Strategy: same method call, different behavior
        String[] modes = {"car", "bike", "walk"};
        for (String mode : modes) {
            PathCalculator pc = PathCalculatorFactory.getPathCalculator(mode);
            System.out.println("  Mode: " + mode.toUpperCase());
            System.out.println("  Path: " + pc.findPath("Indiranagar", "MG Road"));
            System.out.println();
        }

        System.out.println("════════════════════════════════════════");
        System.out.println("  KEY INSIGHT");
        System.out.println("════════════════════════════════════════");
        System.out.println();
        System.out.println("  ✅ GoogleMaps has ZERO if-else blocks");
        System.out.println("  ✅ Adding a new mode = 1 new class + 1 factory entry");
        System.out.println("  ✅ Open-Closed Principle: open for extension, closed for modification");
        System.out.println("  ✅ Single Responsibility: each strategy handles ONE algorithm");
    }
}