package day7;

public class SingletonWithEagerInitialization {
    private static final SingletonWithEagerInitialization instance = new SingletonWithEagerInitialization();
    private SingletonWithEagerInitialization() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }
    public static SingletonWithEagerInitialization getInstance() {
        return instance;
    }


}
