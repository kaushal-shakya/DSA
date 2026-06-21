package lld2.observer.amazonorder;

/**
 * EmailService — Concrete Observer for sending email notifications.
 *
 * Automatically registers itself with the Amazon publisher
 * upon creation. When an order is placed, it sends a
 * confirmation email to the customer.
 */
public class EmailService implements OrderPlacedSubscriber {

    private final Amazon amazon;

    /**
     * Creates an EmailService and registers it with the publisher.
     *
     * @param amazon the publisher to register with
     */
    public EmailService(Amazon amazon) {
        this.amazon = amazon;
        this.amazon.registerOrderPlacedSubscriber(this);
    }

    @Override
    public void onOrderPlaced(String orderId) {
        System.out.println("  📧 [EmailService] Sending confirmation for order: " + orderId);
        System.out.println("     → Composing order confirmation email...");
        System.out.println("     → Attaching order summary and tracking info...");
        System.out.println("     → Email sent to customer successfully!");
    }
}
