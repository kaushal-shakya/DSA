package lld1.lec2oop2.encapsulation;

public class BankAccountDemo {
    public static void main(String[] args) {
        BackAccount bc = new BackAccount();
//        System.out.println(bc.balance);
        bc.deposit(1000);
        System.out.println(bc.getBalance());
    }
}
