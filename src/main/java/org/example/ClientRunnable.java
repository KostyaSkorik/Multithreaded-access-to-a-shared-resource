package org.example;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientRunnable implements Runnable {
    private BankAccount bankAccount;
    private int value = 350;
    private Semaphore semaphore = new Semaphore(1);

    public ClientRunnable(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        }catch (InterruptedException ex){
            Logger.getLogger(ClientRunnable.class.getName()).log(Level.SEVERE, null,ex);
        }
            while (true) {
                System.out.println(Thread.currentThread().getName() + " проверил баланс до покупки: " + bankAccount.getBalance());
                if (bankAccount.getBalance() - value >= 0) {
                    try {
                        Thread.sleep(1500);
                        bankAccount.changeBalance(value);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(Thread.currentThread().getName() + " проверил баланс после покупки: " + bankAccount.getBalance());
                } else {
                    break;
                }
        }semaphore.release();
    }
}
