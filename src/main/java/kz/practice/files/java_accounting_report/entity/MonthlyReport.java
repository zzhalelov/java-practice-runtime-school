package kz.practice.files.java_accounting_report.entity;

import java.util.ArrayList;
import java.util.List;

public class MonthlyReport {
    //обьявляем список транзакций
    private final List<Transaction> transactions;

    //конструктор
    public MonthlyReport() {
        this.transactions = new ArrayList<>();
    }

    //добавить транзакцию в список
    public void addTransaction(String itemName, boolean isExpense, int quantity, int unitPrice) {
        transactions.add((new Transaction(itemName, isExpense, quantity, unitPrice)));
    }

    //геттер
    public List<Transaction> getTransactions() {
        return transactions;
    }

    //поиск самого прибыыльного товара
    public Transaction getMostRevenue() {
        Transaction mostRevenue = null;
        //перебираем список транзакций
        for (Transaction tr : transactions) {
            if (!tr.isExpense()) {
                if (mostRevenue == null || tr.getTotal() > mostRevenue.getTotal()) {
                    mostRevenue = tr;
                }
            }
        }
        return mostRevenue;
    }

    //самый затратный товар
    public Transaction getMostExpensive() {
        Transaction mostExpensive = null;
        for (Transaction tr : transactions) {
            if (tr.isExpense()) {
                if (mostExpensive == null || tr.getTotal() > mostExpensive.getTotal()) {
                    mostExpensive = tr;
                }
            }
        }
        return mostExpensive;
    }
}