package CandyGift;

import java.util.Comparator;

public class MaxWeightComparator  implements Comparator<Sweet> {


    @Override
    public int compare(Sweet a, Sweet b) {
        int dif = (int) (a.weight - b.weight);
        return ( dif < 0.0 ) ? 1 : ( dif > 0.0 ) ? -1 : 0;
    }
}
