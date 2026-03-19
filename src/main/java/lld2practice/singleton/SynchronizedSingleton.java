package lld2practice.singleton;

public class SynchronizedSingleton {

    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {}

    // This is not thread-safe. It will fail in multithreaded environment
    public synchronized static SynchronizedSingleton getInstance() {
        if(instance == null) {
            return new SynchronizedSingleton();
        }
        return instance;
    }
}
