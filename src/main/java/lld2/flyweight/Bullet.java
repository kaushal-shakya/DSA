package lld2.flyweight;

/**
 * Bullet — Extrinsic (unique) state for the Flyweight pattern.
 *
 * Each bullet in the game has its own position, direction, and speed,
 * but they all share the same BulletType (intrinsic state).
 *
 * This class stores ONLY the data that changes per-bullet:
 *   direction (x, y, z)        → 24 bytes
 *   speed                      → 8 bytes
 *   currentCoordinate (x, y, z)→ 24 bytes
 *   targetCoordinate (x, y, z) → 24 bytes
 *   reference to BulletType    → 8 bytes (pointer)
 *                              ─────────
 *                              ≈ 88 bytes per bullet
 *
 * Compare with ~1,100 bytes without Flyweight!
 */
public class Bullet {

    // ── Extrinsic properties (unique per bullet) ──

    private double directionX;
    private double directionY;
    private double directionZ;

    private double speed;

    private double currentX;
    private double currentY;
    private double currentZ;

    private double targetX;
    private double targetY;
    private double targetZ;

    // ── Shared intrinsic state ──

    private final BulletType type;

    public Bullet(BulletType type,
                  double directionX, double directionY, double directionZ,
                  double speed,
                  double currentX, double currentY, double currentZ,
                  double targetX, double targetY, double targetZ) {
        this.type = type;
        this.directionX = directionX;
        this.directionY = directionY;
        this.directionZ = directionZ;
        this.speed = speed;
        this.currentX = currentX;
        this.currentY = currentY;
        this.currentZ = currentZ;
        this.targetX = targetX;
        this.targetY = targetY;
        this.targetZ = targetZ;
    }

    // ── Movement ──

    public void move(double deltaX, double deltaY, double deltaZ) {
        this.currentX += deltaX;
        this.currentY += deltaY;
        this.currentZ += deltaZ;
    }

    // ── Getters ──

    public BulletType getType()   { return type; }
    public double getSpeed()      { return speed; }
    public double getCurrentX()   { return currentX; }
    public double getCurrentY()   { return currentY; }
    public double getCurrentZ()   { return currentZ; }

    @Override
    public String toString() {
        return "Bullet{" +
                "type=" + type.getColor() +
                ", speed=" + speed +
                ", pos=(" + currentX + ", " + currentY + ", " + currentZ + ")" +
                ", target=(" + targetX + ", " + targetY + ", " + targetZ + ")" +
                '}';
    }
}