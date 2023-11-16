package oopsConcept;
class Account {
    private double balance;
    public Account(double initialBalance) {
        if (initialBalance > 0.0) {
            balance = initialBalance;
        }
    }
    public void credit(double amount) {
        balance = balance + amount;
    }
    public void debit(double amount) {
        if (amount > balance) {
            System.out.println("Debit amount exceeded account balance. Transaction canceled.");
        } else {
            balance = balance - amount;
            System.out.println("Debit successful. Remaining balance: $" + balance);
        }
    }
    public double getBalance() {
        return balance;
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account(50.00);
        Account account2 = new Account(-7.53);

        System.out.printf("account1 balance: $%.2f%n", account1.getBalance());
        System.out.printf("account2 balance: $%.2f%n%n", account2.getBalance());

        account1.debit(30.00);
        account2.debit(10.00);

        System.out.printf("account1 balance: $%.2f%n", account1.getBalance());
        System.out.printf("account2 balance: $%.2f%n", account2.getBalance());
    }
}
