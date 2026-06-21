package lld2.observer.amazonorder;

/**
 * OrderPlacedSubscriber — Observer interface for the Observer pattern.
 *
 * Any class that wants to react when an order is placed must
 * implement this interface. The publisher (Amazon) notifies
 * all registered subscribers by calling onOrderPlaced().
 *
 * This is the "Observer" in the Observer Design Pattern —
 * the common interface that all subscribers must implement.
 */
public interface OrderPlacedSubscriber {

    /**
     * Called by the publisher when an order is placed.
     * Each subscriber implements its own reaction logic.
     *
     * @param orderId the ID of the placed order
     */
    void onOrderPlaced(String orderId);
}
