package day3_day4;

public class a5UserRegistration {

    public static void main(String[] args) {
        try {
            registerUser("Digvijay","India");
            registerUser("Digvijay","USA");
        } catch (InvalidCountryException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void registerUser(String username,String country) {
        if (country.equals("India")) {
            System.out.println("User registration done successfully");
        }
        else {
            throw new InvalidCountryException();
        }
    }
}
