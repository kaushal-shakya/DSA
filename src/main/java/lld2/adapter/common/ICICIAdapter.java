package lld2.adapter.common;

public class ICICIAdapter implements CommonBankAPI{
    @Override
    public void sendMoney() {
        System.out.println("---Sending money via ICICIAdapter Bank.");
    }

    @Override
    public void checkBalance() {
        System.out.println("---Your Current Balance si 10000.----");
    }
}
