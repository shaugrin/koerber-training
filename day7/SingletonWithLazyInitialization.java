package day7;

public class SingletonWithLazyInitialization {
    private static SingletonWithLazyInitialization instance;

    private SingletonWithLazyInitialization() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static SingletonWithLazyInitialization getInstance() {
        if (instance == null) {
            instance = new SingletonWithLazyInitialization();
        }
        return instance;
    }
}
