package day3_day4;

public class InvalidCountryException extends RuntimeException {
    public InvalidCountryException(String message) {
        super(message);
    }

    public InvalidCountryException() {
        super("User outside India cannot be registered");
    }
}
