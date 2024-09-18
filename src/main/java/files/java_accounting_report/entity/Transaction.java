package files.java_accounting_report.entity;

public class Transaction {
    private final String itemName;
    private final boolean isExpense;
    private final int quantity;
    private final int unitPrice;

    //конструктор
    public Transaction(String itemName, boolean isExpense, int quantity, int unitPrice) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    //геттеры
    //сеттеры не нужны, т.к. не будут устанавливаться значения
    //значения будут только считываться
    public String getItemName() {
        return itemName;
    }

    public boolean isExpense() {
        return isExpense;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotal() {
        return unitPrice * quantity;
    }
}