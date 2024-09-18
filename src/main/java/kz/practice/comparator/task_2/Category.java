package kz.practice.comparator.task_2;

import java.util.ArrayList;
import java.util.List;

public record Category(String name, List<Product> products) {
    public Category(String name) {
        this(name, new ArrayList<>());
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    // TODO: реализовать метод для получения сумму всех товаров категорий
    public double getProductsSum() {
        double sum = 0.0;
        for (Product product : products) {
            sum += product.price();
        }
        return sum;
    }

    // TODO: реализовать метод для получения среднего количество дней годности
    public double averageExpiryDays() {
        double days = 0.0;
        for (Product product : products) {
            days += product.expiringDays();
        }
        return days / products.size();
    }
}