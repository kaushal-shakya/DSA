package lld2practice.singleton;

public class EagerInitializationPracticeSingleton {
    private static EagerInitializationPracticeSingleton instance = new EagerInitializationPracticeSingleton();

    private EagerInitializationPracticeSingleton() {}

    //Cons :
    //  1. Slower startup
    //  2. High resource utilization
    //  3. No control over object creation.
    //  4. Wastes memory
    //Pros :
    //  1. Thread safe.
    //  2. Instance always ready
    public static EagerInitializationPracticeSingleton getInstance() {
        return instance;
    }
}
