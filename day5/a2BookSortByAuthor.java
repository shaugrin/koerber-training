package day5;

import java.util.Comparator;

public class a2BookSortByAuthor implements Comparator<a2Book> {

    @Override
    public int compare(a2Book o1, a2Book o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }
}
