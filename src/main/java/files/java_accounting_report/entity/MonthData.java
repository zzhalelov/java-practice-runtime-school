package files.java_accounting_report.entity;

public class MonthData {
    private final int month;
    private int income;
    private int expense;

    //конструктор
    public MonthData(int month) {
        this.month = month;
        this.income = 0;
        this.expense = 0;
    }

    public void addTransaction(int amount, boolean isExpense) {
        if (isExpense) {
            expense += amount;
        } else {
            income += amount;
        }
    }

    //геттеры
    public int getIncome() {
        return income;
    }

    public int getExpense() {
        return expense;
    }
}