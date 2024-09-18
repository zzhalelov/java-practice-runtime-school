package files.java_accounting_report.entity;

import java.util.HashMap;
import java.util.Map;

public class YearlyReport {
    private final Map<Integer, MonthData> monthDataMap;

    public YearlyReport() {
        this.monthDataMap = new HashMap<>();
    }

    public void addMonthData(int month, int amount, boolean isExpense) {
        if (!monthDataMap.containsKey(month)) {
            monthDataMap.put(month, new MonthData(month));
        }
        monthDataMap.get(month).addTransaction(amount, isExpense);
    }

    public Map<Integer, MonthData> getMonthDataMap() {
        return monthDataMap;
    }

    public int getTotalIncome() {
        int totalIncome = 0;
        for (MonthData data : monthDataMap.values()) {
            totalIncome += data.getIncome();
        }
        return totalIncome;
    }

    public int getTotalExpenses() {
        int totalExpenses = 0;
        for (MonthData data : monthDataMap.values()) {
            totalExpenses += data.getExpense();
        }
        return totalExpenses;
    }

    public int getProfit(int month) {
        MonthData data = monthDataMap.getOrDefault(month, new MonthData(month));
        if (data != null) {
            return data.getIncome() - data.getExpense();
        } else {
            return 0;
        }
    }

    //расчет среднего дохода
    public double averageIncome() {
        double totalIncome = 0;
        int count = 0;
        for (MonthData data : monthDataMap.values()) {
            totalIncome += data.getIncome();
            count++;
        }
        return count > 0 ? (double) totalIncome / count : 0;
    }

    //расчет среднего расхода
    public double averageExpense() {
        double totalExpense = 0;
        int count = 0;
        for (MonthData data : monthDataMap.values()) {
            totalExpense += data.getExpense();
            count++;
        }
        return count > 0 ? (double) totalExpense / count : 0;
    }
}