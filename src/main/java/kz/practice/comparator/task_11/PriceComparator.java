package kz.practice.comparator.task_11;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.price() - o2.price());
    }
}