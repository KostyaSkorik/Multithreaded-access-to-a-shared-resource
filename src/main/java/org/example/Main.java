package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(1234567812345678L,1000);
        Runnable rn = new ClientRunnable(account);
        Thread client1 = new Thread(rn, "Клиент 1");
        Thread client2 = new Thread(rn, "Клиент 2");
        client1.start();
        client2.start();
        try {
            client1.join();
            client2.join();
        }catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Баланс после покупок: "+ account.getBalance());
    }
}