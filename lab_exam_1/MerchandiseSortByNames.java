package day5;

import java.util.Comparator;

public class MerchandiseSortByNames implements Comparator<Merchandise> {

    @Override
    public int compare(Merchandise o1, Merchandise o2) {
        return o1.getItemId().compareTo(o2.getItemId());
    }
}