package kz.practice.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import kz.practice.jpa.entity.Category;
import kz.practice.jpa.entity.Option;
import kz.practice.jpa.entity.Product;
import kz.practice.jpa.entity.Value;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String command = scanner.nextLine();
            switch (command) {
                case "1" -> create();
                case "0" -> {
                    System.out.println("Exit");
                    return;
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("""
                - Create [1]
                - Update [2]
                - Delete [3]
                Select an action: \
                """);
        System.out.println("0. Exit");
    }

    private static void create() {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();

            // Select categories to display as list
            TypedQuery<Category> categoryTypedQuery = manager.createQuery(
                    "SELECT c FROM Category c ORDER BY c.name", Category.class
            );
            List<Category> categories = categoryTypedQuery.getResultList();
            for (int i = 0; i < categories.size(); i++) {
                System.out.println(categories.get(i).getName());
            }

            // Input category number
            System.out.print("Select category by number: ");
            String categoryNumString = scanner.nextLine();
            int categoryNum = Integer.parseInt(categoryNumString);
            Category category = categories.get(categoryNum);

            // Input product name
            System.out.print("Input product's name: ");
            String productNameString = scanner.nextLine();

            // Input product price
            System.out.print("Input product's price: ");
            String productPriceString = scanner.nextLine();
            double productPrice = Double.parseDouble(productPriceString);

            // Create product entity
            Product product = new Product();
            product.setCategory(category);
            product.setName(productNameString);
            product.setPrice(productPrice);

            // Persist product entity to database
            manager.persist(product);

            // Iterate category options
            for (Option option : category.getOptions()) {
                // Input option value
                System.out.print(option.getName() + ": ");
                String valueString = scanner.nextLine();

                // Create value entity
                Value value = new Value();
                value.setProduct(product);
                value.setOption(option);
                value.setValue(valueString);

                // Persist value entity to database
                manager.persist(value);
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }
}