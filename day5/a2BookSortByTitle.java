package day5;

import java.util.Comparator;
import java.util.List;

public class a2BookSortByTitle implements Comparator<a2Book>{

    @Override
    public int compare(a2Book o1, a2Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
