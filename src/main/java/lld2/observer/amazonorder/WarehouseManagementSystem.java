package lld2.observer.amazonorder;

/**
 * WarehouseManagementSystem — Concrete Observer for warehouse updates.
 *
 * Automatically registers itself with the Amazon publisher
 * upon creation. When an order is placed, it updates the
 * warehouse by reserving stock and scheduling packing.
 */
public class WarehouseManagementSystem implements OrderPlacedSubscriber {

    private final Amazon amazon;

    /**
     * Creates a WarehouseManagementSystem and registers it with the publisher.
     *
     * @param amazon the publisher to register with
     */
    public WarehouseManagementSystem(Amazon amazon) {
        this.amazon = amazon;
        this.amazon.registerOrderPlacedSubscriber(this);
    }

    @Override
    public void onOrderPlaced(String orderId) {
        System.out.println("  🏭 [WarehouseManagement] Updating warehouse for order: " + orderId);
        System.out.println("     → Reserving items in warehouse...");
        System.out.println("     → Scheduling packing and dispatch...");
        System.out.println("     → Warehouse updated successfully!");
    }
}