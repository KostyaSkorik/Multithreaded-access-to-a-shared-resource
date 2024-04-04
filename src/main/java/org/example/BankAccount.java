package org.example;

public class BankAccount {
    private long number;
    private int balance;

    public BankAccount(long number, int balance) {
        this.number = number;
        this.balance = balance;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void changeBalance(int value){
        this.balance-=value;
    }
}
