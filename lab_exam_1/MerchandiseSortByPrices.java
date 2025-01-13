package day5;

import java.util.Comparator;

public class MerchandiseSortByPrices implements Comparator<Merchandise> {

    @Override
    public int compare(Merchandise o1, Merchandise o2) {
        return Double.compare(o2.getPrice(), o1.getPrice());
    }

}
