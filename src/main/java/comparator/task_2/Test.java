package comparator.task_2;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Category> categories = new ArrayList<>();

        Category dairy = new Category("Молочные продукты");
        dairy.addProduct(new Product("Кефир", 420, 7));
        dairy.addProduct(new Product("Творог", 900, 5));
        dairy.addProduct(new Product("Сметана", 600, 2));
        categories.add(dairy);

        Category fruits = new Category("Фрукты");
        fruits.addProduct(new Product("Бананы", 1280, 5));
        fruits.addProduct(new Product("Яблоки", 900, 50));
        fruits.addProduct(new Product("Ананасы", 3800, 24));
        categories.add(fruits);

        Category vegetables = new Category("Овощи");
        vegetables.addProduct(new Product("Помидоры", 420, 14));
        vegetables.addProduct(new Product("Огурцы", 900, 14));
        vegetables.addProduct(new Product("Морковь", 380, 32));
        categories.add(vegetables);

        Category meat = new Category("Мясо");
        meat.addProduct(new Product("Курица", 1280, 90));
        meat.addProduct(new Product("Говядина", 1900, 180));
        categories.add(meat);

        Category cereals = new Category("Крупы");
        cereals.addProduct(new Product("Гречка", 600, 730));
        cereals.addProduct(new Product("Рис", 420, 550));
        cereals.addProduct(new Product("Овсянка", 380, 120));
        categories.add(cereals);

        //добавить все продукты в один список
        List<Product> allProducts = new ArrayList<>();
        for (Category category : categories) {
            allProducts.addAll(category.products());
        }

        PriceComparator priceComparator = new PriceComparator();
        allProducts.sort(priceComparator);

        for (Product product : allProducts) {
            System.out.println(product);
        }
    }
}
