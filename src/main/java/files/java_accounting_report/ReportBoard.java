package files.java_accounting_report;

import files.java_accounting_report.entity.MonthData;
import files.java_accounting_report.entity.MonthlyReport;
import files.java_accounting_report.entity.Transaction;
import files.java_accounting_report.entity.YearlyReport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportBoard {
    private final Map<String, MonthlyReport> monthlyReports;
    private YearlyReport yearlyReport;

    public ReportBoard() {
        monthlyReports = new HashMap<>();
    }

    //считать месячный отчет
    public void loadMonthlyReports() {
        for (int month = 1; month <= 3; month++) {
            String monthString = String.format("%02d", month);
            String fileName = "m.2021" + monthString + ".csv";
            MonthlyReport monthlyReport = parseMonthlyReport(fileName);
            if (monthlyReport != null) {
                monthlyReports.put(monthString, monthlyReport);
            }
        }
        System.out.println("Месячные отчёты считаны.");
    }

    //считать годовой отчет
    public void loadYearlyReport() {
        yearlyReport = parseYearlyReport("y.2021.csv");
        System.out.println("Годовой отчёт считан.");
    }

    //сверка месячных и годовых отчетов
    public void checkReports() {
        if (monthlyReports.isEmpty() || yearlyReport == null) {
            System.out.println("Отчёты не были считаны. Сначала загрузите их.");
            return;
        }

        for (int month = 1; month <= 3; month++) {
            String monthString = String.format("%02d", month);
            MonthlyReport monthlyReport = monthlyReports.get(monthString);
            MonthData yearlyData = yearlyReport.getMonthDataMap().get(month);

            int monthlyIncome = 0;
            for (Transaction t : monthlyReport.getTransactions()) {
                if (!t.isExpense()) {
                    monthlyIncome += t.getTotal();
                }
            }

            int monthlyExpense = 0;
            for (Transaction t : monthlyReport.getTransactions()) {
                if (t.isExpense()) {
                    monthlyExpense += t.getTotal();
                }
            }

            if (yearlyData == null || monthlyIncome != yearlyData.getIncome() || monthlyExpense != yearlyData.getExpense()) {
                System.out.println("Найдена ошибка в месяце: " + month);
            }
        }
        System.out.println("Сверка завершена.");
    }

    public void printMonthlyReports() {
        if (monthlyReports.isEmpty()) {
            System.out.println("Месячные отчёты не были считаны. Сначала загрузите их.");
            return;
        }

        for (int month = 1; month <= 3; month++) {
            String monthString = String.format("%02d", month);
            MonthlyReport report = monthlyReports.get(monthString);
            Transaction mostProfitableItem = report.getMostRevenue();
            Transaction largestExpense = report.getMostExpensive();

            System.out.println("Месяц: " + monthString);
            System.out.println("Самый прибыльный товар: " + mostProfitableItem.getItemName() + " на сумму " + mostProfitableItem.getTotal());
            System.out.println("Самая большая трата: " + largestExpense.getItemName() + " на сумму " + largestExpense.getTotal());
            System.out.println();
        }
    }

    public void printYearlyReport() {
        if (yearlyReport == null) {
            System.out.println("Годовой отчёт не был считан. Сначала загрузите его.");
            return;
        }

        System.out.println("Год: 2021");

        for (int month = 1; month <= 3; month++) {
            int profit = yearlyReport.getProfit(month);
            System.out.println("Месяц " + month + ": Прибыль = " + profit);
        }

        System.out.println("Средний расход за год: " + yearlyReport.averageExpense());
        System.out.println("Средний доход за год: " + yearlyReport.averageIncome());
    }

    private MonthlyReport parseMonthlyReport(String fileName) {

        try {
            List<String> lines = Files.readAllLines(Path.of("src/main/java/files/java_accounting_report/data/" + fileName));
            MonthlyReport report = new MonthlyReport();

            for (int i = 1; i < lines.size(); i++) {
                String[] columns = lines.get(i).split(",");
                String itemName = columns[0];
                boolean isExpense = Boolean.parseBoolean(columns[1]);
                int quantity = Integer.parseInt(columns[2]);
                int unitPrice = Integer.parseInt(columns[3]);
                report.addTransaction(itemName, isExpense, quantity, unitPrice);
            }
            return report;
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + fileName);
            return null;
        }
    }

    private YearlyReport parseYearlyReport(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Path.of("src/main/java/files/java_accounting_report/data/" + fileName));
            YearlyReport report = new YearlyReport();

            for (int i = 1; i < lines.size(); i++) {
                String[] columns = lines.get(i).split(",");
                int month = Integer.parseInt(columns[0]);
                int amount = Integer.parseInt(columns[1]);
                boolean isExpense = Boolean.parseBoolean(columns[2]);
                report.addMonthData(month, amount, isExpense);
            }
            return report;
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + fileName);
            return null;
        }
    }
}