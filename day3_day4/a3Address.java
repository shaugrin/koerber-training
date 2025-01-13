package day3_day4;

import java.io.Serializable;

public class a3Address implements Serializable {
    String city;
    String state;
    String country;
    String exactAddress;

    public a3Address(String city, String state, String country, String exactAddress) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.exactAddress = exactAddress;
    }
}
