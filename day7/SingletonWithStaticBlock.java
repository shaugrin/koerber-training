package day7;

public class SingletonWithStaticBlock {

    private static final SingletonWithStaticBlock instance;

    static {
        try {
            instance = new SingletonWithStaticBlock();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private SingletonWithStaticBlock() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static SingletonWithStaticBlock getInstance() {
        return instance;
    }
}
