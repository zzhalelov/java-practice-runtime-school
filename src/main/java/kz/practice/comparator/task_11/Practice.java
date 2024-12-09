package kz.practice.comparator.task_11;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        PriceComparator comparator = new PriceComparator();
        List<Product> products = new ArrayList<>();
        products.add(new Product("apple", 450.00, 5));
        products.add(new Product("strawberry", 1100.00, 5));
        products.add(new Product("pear", 850.00, 3));
        products.add(new Product("tomato", 350.00, 2));
        products.add(new Product("banana", 280.00, 3));

        products.sort(comparator);
        products.removeIf(n -> n.rating() < 4);
        System.out.println(products);
    }
}