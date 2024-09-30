package kz.practice.jUnit.task_2;

public class BankAccount {
    private boolean isBlocked = false;
    private Integer amount;
    private String currency;

    private final String firstName;
    private final String secondName;

    public BankAccount(String firstName, String lastName) {
        this.firstName = firstName;
        this.secondName = lastName;
    }

    public void block() {
        this.isBlocked = true;
    }

    public void activate(String currency) {
        this.amount = 0;
        this.currency = currency;
    }

    public Integer getAmount() {
        if (amount == null) {
            throw new IllegalStateException("Счёт не активирован.");
        }
        return this.amount;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public String[] getFullName() {
        return new String[]{firstName, secondName};
    }

    public void withdraw(int amount) {
        if (this.amount == null) {
            throw new IllegalStateException("Счет не активирован");
        }
        if (this.isBlocked) {
            throw new IllegalStateException("Счет заблокирован");
        }
        if (amount > this.amount) {
            throw new IllegalArgumentException("Недостаточно средств");
        }
        this.amount -= amount;
    }

    public void transfer(BankAccount newAccount, int amount) {
        if (this.amount == null || newAccount.getAmount() == null) {
            throw new IllegalStateException("счета не активны");
        }
        if (this.isBlocked) {
            throw new IllegalStateException("Счет заблокирован");
        }
        if (!this.currency.equals(newAccount.getCurrency())) {
            throw new IllegalArgumentException("Разные валюьы");
        }
        if (amount > this.amount) {
            throw new IllegalArgumentException("Недостаточно средств");
        }
        this.amount -= amount;
        newAccount.amount += amount;
    }
}