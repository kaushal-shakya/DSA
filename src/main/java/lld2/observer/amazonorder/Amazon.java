package lld2.observer.amazonorder;

import java.util.ArrayList;
import java.util.List;

/**
 * Amazon — Publisher (Subject) in the Observer pattern.
 *
 * Maintains a list of OrderPlacedSubscriber objects and notifies
 * all of them whenever an order is placed. Subscribers can
 * register and unregister themselves at any time — even at runtime.
 *
 * Key advantages over the Facade approach:
 * ✅ New subscribers can be added WITHOUT modifying this class
 * ✅ Subscribers can register/unregister at RUNTIME
 * ✅ Open-Closed Principle: open for extension, closed for modification
 */
public class Amazon {

    private final List<OrderPlacedSubscriber> subscribers = new ArrayList<>();

    // Register as subscriber
    public void registerOrderPlacedSubscriber(OrderPlacedSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    // Unregister as subscriber
    public void unregisterOrderPlacedSubscriber(OrderPlacedSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    // place order and notify all subscribers
    public void orderPlaced(String orderId) {
        // algorithm to place order
        // notify all subscriber services
        for (OrderPlacedSubscriber subscriber: subscribers) {
            subscriber.onOrderPlaced(orderId);
        }
    }

    public int getSubscriberCount() {
        return subscribers.size();
    }

}