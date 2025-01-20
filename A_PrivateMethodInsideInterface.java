package java9.features;
//private method inside an interface
//interface Foof{
//}
 interface Java8DBLogging
{
    default void logInfo()
    {
        log();
    }

    default void logWarn()
    {
        log();
    }

    default void logError()
    {
        log();
    }

    private void log()
    {
        System.out.println(" Step1: Connect to DataBase");
        System.out.println(" Setp2: Log Message");
        System.out.println("Setp3: Close the DataBase connection");
    }

}

public class A_PrivateMethodInsideInterface implements Java8DBLogging {
    public static void main(String[] args) {
        A_PrivateMethodInsideInterface obj = new A_PrivateMethodInsideInterface();
        obj.logInfo();
        obj.logWarn();
        obj.logError();
    }
}
















