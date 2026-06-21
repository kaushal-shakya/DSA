package lld2.flyweight;

/**
 * BulletType — Intrinsic (shared) state for the Flyweight pattern.
 *
 * Holds properties that are IDENTICAL across all bullets of the
 * same type: color, weight, radius, max damage, max range, and image.
 *
 * These objects are created once and shared by thousands of Bullet
 * instances, saving ~1 KB per bullet (the image alone is ~1 KB).
 *
 * ┌──────────────────────────────────────────────────┐
 * │  Without Flyweight:  100,000 bullets × 1.1 KB    │
 * │                      ≈ 110 MB RAM                │
 * │                                                  │
 * │  With Flyweight:     100,000 × 0.06 KB (extrinsic) │
 * │                      + 5 × 1.04 KB (intrinsic)   │
 * │                      ≈ 6 MB RAM                  │
 * └──────────────────────────────────────────────────┘
 *
 * This class is IMMUTABLE — safe to share across threads.
 */
public class BulletType {

    private final String color;       // e.g. "GOLD", "SILVER"
    private final double weight;      // grams
    private final double radius;      // millimetres
    private final int maxDamage;      // hit-points
    private final int maxRange;       // metres
    private final byte[] image;       // sprite data (~1 KB)

    public BulletType(String color, double weight, double radius,
                      int maxDamage, int maxRange, byte[] image) {
        this.color = color;
        this.weight = weight;
        this.radius = radius;
        this.maxDamage = maxDamage;
        this.maxRange = maxRange;
        this.image = image;
    }

    // ── Getters ──

    public String getColor()    { return color; }
    public double getWeight()   { return weight; }
    public double getRadius()   { return radius; }
    public int getMaxDamage()   { return maxDamage; }
    public int getMaxRange()    { return maxRange; }
    public byte[] getImage()    { return image; }

    @Override
    public String toString() {
        return "BulletType{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                ", radius=" + radius +
                ", maxDamage=" + maxDamage +
                ", maxRange=" + maxRange +
                ", imageSize=" + (image != null ? image.length : 0) + " bytes" +
                '}';
    }
}