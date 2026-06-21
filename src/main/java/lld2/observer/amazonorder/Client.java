package lld2.observer.amazonorder;

/**
 * Client — Runnable demo for the Observer Design Pattern.
 *
 * Demonstrates:
 * 1. Subscribers self-registering with the publisher
 * 2. Publisher notifying all subscribers on an event
 * 3. Dynamic unregistration at runtime
 * 4. Adding new subscribers without modifying the publisher
 */
public class Client {

    public static void main(String[] args) {

        System.out.println("════════════════════════════════════════");
        System.out.println("  DEMO 1: Setting Up the Observer Pattern");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        // ── Create the publisher ──
        Amazon amazon = new Amazon();

        // ── Create subscribers — they self-register in their constructors ──
        System.out.println("  Creating subscribers (self-registration):");
        InvoiceGenerator invoiceGen = new InvoiceGenerator(amazon);
        WarehouseManagementSystem wms = new WarehouseManagementSystem(amazon);
        InventoryManagementSystem ims = new InventoryManagementSystem(amazon);
        EmailService emailService = new EmailService(amazon);

        System.out.println();
        System.out.println("  Total subscribers: " + amazon.getSubscriberCount());

        System.out.println();
        System.out.println("════════════════════════════════════════");
        System.out.println("  DEMO 2: Placing an Order");
        System.out.println("  (All 4 subscribers get notified)");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        // ── Place an order — ALL subscribers are notified automatically ──
        amazon.orderPlaced("ORD-2024-001");

        System.out.println("════════════════════════════════════════");
        System.out.println("  DEMO 3: Runtime Unregistration");
        System.out.println("  (Remove EmailService, then place order)");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        // ── Unregister the email service at runtime ──
        amazon.unregisterOrderPlacedSubscriber(emailService);
        System.out.println("  Total subscribers now: " + amazon.getSubscriberCount());
        System.out.println();

        // ── Place another order — only 3 subscribers notified ──
        amazon.orderPlaced("ORD-2024-002");

        System.out.println("════════════════════════════════════════");
        System.out.println("  DEMO 4: Adding a New Subscriber at Runtime");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        // ── Re-register email + add a new anonymous subscriber ──
        amazon.registerOrderPlacedSubscriber(emailService);

        // Adding a brand-new subscriber at runtime — no code changes to Amazon!
        amazon.registerOrderPlacedSubscriber(new OrderPlacedSubscriber() {
            @Override
            public void onOrderPlaced(String orderId) {
                System.out.println("  📱 [SMSNotifier] Sending SMS for order: " + orderId);
                System.out.println("     → SMS sent to customer's phone!");
            }
        });

        System.out.println("  Total subscribers now: " + amazon.getSubscriberCount());
        System.out.println();

        amazon.orderPlaced("ORD-2024-003");

        System.out.println("════════════════════════════════════════");
        System.out.println("  KEY INSIGHTS");
        System.out.println("════════════════════════════════════════");
        System.out.println();
        System.out.println("  ✅ Publisher (Amazon) doesn't know WHAT subscribers do");
        System.out.println("  ✅ Subscribers self-register — publisher just maintains a list");
        System.out.println("  ✅ Add/remove subscribers at RUNTIME — no code changes");
        System.out.println("  ✅ Open-Closed Principle: new subscriber = new class, zero publisher changes");
        System.out.println("  ✅ vs Facade: Facade requires updating the facade class for every new operation");
    }
}