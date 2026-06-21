package lld2.observer.amazonorder;

/**
 * InvoiceGenerator — Concrete Observer that generates invoices.
 *
 * Automatically registers itself with the Amazon publisher
 * upon creation. When an order is placed, it generates an
 * invoice with pricing and tax information.
 */
public class InvoiceGenerator implements OrderPlacedSubscriber {

    private final Amazon amazon;

    /**
     * Creates an InvoiceGenerator and registers it with the publisher.
     *
     * @param amazon the publisher to register with
     */
    public InvoiceGenerator(Amazon amazon) {
        this.amazon = amazon;
        // Self-registration: the subscriber registers itself with the publisher
        amazon.registerOrderPlacedSubscriber(this);
    }

    @Override
    public void onOrderPlaced(String orderId) {
        System.out.println("  📄 [InvoiceGenerator] Generating invoice for order: " + orderId);
        System.out.println("     → Calculating item prices...");
        System.out.println("     → Applying taxes (18% GST)...");
        System.out.println("     → Invoice generated successfully!");
    }
}