package kz.practice.comparator.task_2;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return (int) (product2.price() - product1.price());
    }
}