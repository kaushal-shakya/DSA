package lld2practice.singleton;

public class LazyInitializationPracticeSingleton {

    private static LazyInitializationPracticeSingleton instance;

    private LazyInitializationPracticeSingleton() {}

    // This is not thread-safe. It will fail in multithreaded environment
    public static LazyInitializationPracticeSingleton getInstance() {
        if(instance == null) {
            return new LazyInitializationPracticeSingleton();
        }
        return instance;
    }
}
