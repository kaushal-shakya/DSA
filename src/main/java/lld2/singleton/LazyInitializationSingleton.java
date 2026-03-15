package lld2.singleton;

public class LazyInitializationSingleton {
    // Private instance variable
    private static LazyInitializationSingleton instance = null;

    // Private constructor to prevent external instantiation
    private LazyInitializationSingleton(){
    }

    public static LazyInitializationSingleton getInstance() {
        // Breaks in multithreading
        //        Two threads call getInstance() simultaneously.
        //        Both create objects → two instances created ❌
        if(instance == null)
            instance = new LazyInitializationSingleton();
        return instance;
    }
}

class LazyInitializationSingletonMain {
    public static void main(String[] args) {

    }
}
