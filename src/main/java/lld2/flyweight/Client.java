package lld2.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * Client — demonstrates the Flyweight Design Pattern.
 *
 * Simulates a PUBG-style game where 100 players fire thousands of
 * bullets. Shows how sharing intrinsic state (BulletType) across
 * bullets dramatically reduces memory usage.
 *
 * Memory comparison (from the lecture):
 *   Without Flyweight: 100,000 bullets × 1.1 KB ≈ 110 MB
 *   With Flyweight:    100,000 × 0.088 KB + 5 × 1.04 KB ≈ 8.8 MB
 */
public class Client {

    public static void main(String[] args) {

        System.out.println("════════════════════════════════════════");
        System.out.println("  FLYWEIGHT DESIGN PATTERN");
        System.out.println("  (PUBG Bullet Optimization)");
        System.out.println("════════════════════════════════════════");


    }
}