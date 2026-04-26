package lld1.lec2oop2.encapsulation;

public class BackAccount {
    private double balance;

    public void deposit(double amount) { // controlled access
        if(amount > 0)
            balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
