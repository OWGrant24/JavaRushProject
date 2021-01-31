package Test;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantLock_ {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();
        Thread thread1 = new Thread(() -> {
            runner.firstThread();
        });
        Thread thread2 = new Thread(() -> {
            runner.secondThread();
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        runner.finished();
    }
    public static class Runner {
        private final Account account1 = new Account();
        private final Account account2 = new Account();
        private Lock lock1 = new ReentrantLock();
        private Lock lock2 = new ReentrantLock();


        public void firstThread() {
            lock1.lock();
            lock2.lock();
            try {
                for (int i = 0; i < 100; i++) {
                    Account.transfer(account1, account2, new Random().nextInt(100));
                }
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
        public void secondThread() {
                lock1.lock();
                lock2.lock();
            try {
                for (int i = 0; i < 100; i++) {
                    Account.transfer(account2, account1, new Random().nextInt(100));
                }
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
        public void finished(){
            System.out.println("Баланс 1 аккаунта: " + account1.getBalance());
            System.out.println("Баланс 2 аккаунта: " + account2.getBalance());
            System.out.println("Общий баланс: " + (account1.getBalance() + account2.getBalance()));
        }
    }
    public static class Account {
        private int balance = 10000;
        public void deposit(int amount){
            balance += amount;
        }
        public void withdraw(int amount){
            balance -= amount;
        }
        public int getBalance(){
            return balance;
        }
        public static void transfer(Account acc1, Account acc2, int amount) {
            acc1.withdraw(amount);
            acc2.deposit(amount);
        }
    }
}
