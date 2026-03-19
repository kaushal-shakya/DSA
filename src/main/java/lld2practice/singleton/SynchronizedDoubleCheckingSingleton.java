package lld2practice.singleton;

public class SynchronizedDoubleCheckingSingleton {

    private static SynchronizedDoubleCheckingSingleton instance;

    private SynchronizedDoubleCheckingSingleton() {}

    public static SynchronizedDoubleCheckingSingleton getInstance() {

        if(instance == null ) {
            synchronized (SynchronizedDoubleCheckingSingleton.class) {
                if(instance == null) {
                    return new SynchronizedDoubleCheckingSingleton();
                }
            }
        }

        return instance;
    }
}
