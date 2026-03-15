package lld2.singleton;

public class DoubleChecking {
    private static DoubleChecking instance = null;

    // Private constructor to prevent external instantiation
    private DoubleChecking(){
    }

    public static DoubleChecking getInstance() {
        if(instance == null) {
//            lock();
            if(instance == null) {
                instance = new DoubleChecking();
            }
//            unlock();
        }
        return instance;
    }
}
