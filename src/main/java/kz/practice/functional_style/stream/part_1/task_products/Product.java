package kz.practice.functional_style.stream.part_1.task_products;

record Product(String name, int price, ProductType type) {

    @Override
    public String toString() {
        return "Product[" +
                "name=" + name + ", " +
                "price=" + price + ", " +
                "type=" + type + ']';
    }
}