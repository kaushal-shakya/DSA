package lld2.singleton;

public class EagerInitializationSingleton {
    private static EagerInitializationSingleton instance = new EagerInitializationSingleton(); //creates Singleton instance when the class is loaded.

    private EagerInitializationSingleton(){
    }

    private static EagerInitializationSingleton getInstance(){
        return instance;
    }
}
