package functional_style.stream.task_products;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Яблоко", 450, ProductType.FRUIT));
        products.add(new Product("Банан", 700, ProductType.FRUIT));
        products.add(new Product("Морковь", 300, ProductType.VEGETABLE));
        products.add(new Product("Помидор", 600, ProductType.VEGETABLE));
        products.add(new Product("Апельсин", 800, ProductType.FRUIT));
        products.add(new Product("Огурец", 400, ProductType.VEGETABLE));
        products.add(new Product("Виноград", 1200, ProductType.FRUIT));
        products.add(new Product("Картофель", 200, ProductType.VEGETABLE));
        products.add(new Product("Говядина", 4500, ProductType.MEAT));
        products.add(new Product("Курица", 2000, ProductType.MEAT));
        products.add(new Product("Свинина", 3000, ProductType.MEAT));
        products.add(new Product("Молоко", 500, ProductType.DAIRY));
        products.add(new Product("Сыр", 1500, ProductType.DAIRY));
        products.add(new Product("Йогурт", 800, ProductType.DAIRY));

        //1. Найдите все фрукты в списке и выведите их названия
        List<String> friutList = products.stream()
                .filter(fruit -> fruit.type().equals(ProductType.FRUIT))
                .map(Product::name)
                .toList();
        System.out.println(friutList);

        //2. Подсчитайте, сколько овощей находится в списке (.count())
        long result = products.stream()
                .filter(vegetable -> vegetable.type().equals(ProductType.VEGETABLE))
                .count();
        System.out.println(result);

        //3. Найдите все продукты, цена которых находится в диапазоне от 1000 до 2000 тенге
        List<Product> priceInterval = products.stream()
                .filter(product -> product.price() > 1000 && product.price() < 2000)
                .toList();
        System.out.println(priceInterval);

        //4. Найдите все фрукты, у которых цена меньше 1000 тенге
        // увеличьте цену каждого из них на 20%
        // отсортируйте их по возрастанию цены
        // соберите результаты в новый список продуктов.
        List<Product> newList = products.stream()
                .filter(product -> product.type().equals(ProductType.FRUIT) && product.price() < 1000)
                .map(product -> new Product(product.name(), (int) (product.price() * 1.20), product.type()))
                .sorted(Comparator.comparing(Product::price))
                .toList();
        System.out.println(newList);

        //5. Найдите общую стоимость всех мясных и молочных продуктов
        // цена которых после скидки в 10% больше 2000 тенге
        // отсортируйте их по убыванию цены
        // выведите названия вместе с их новыми ценами.
        List<Product> filteredList = products.stream()
                .filter(product -> product.type().equals(ProductType.MEAT) || product.type().equals(ProductType.DAIRY))
                .map(product -> new Product(product.name(), (int) (product.price() * 0.9), product.type()))
                .filter(product -> product.price() > 2000)
                .sorted(Comparator.comparing(Product::price).reversed())
                .toList();

        for (Product product : filteredList) {
            System.out.println(product.name() + " - " + product.price() + " тенге");
        }

        int sum = filteredList.stream()
                .mapToInt(Product::price)
                .sum();
        System.out.println("Сумма товаров по отбору: " + sum);
    }
}