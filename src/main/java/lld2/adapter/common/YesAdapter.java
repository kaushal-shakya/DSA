package lld2.adapter.common;

public class YesAdapter implements CommonBankAPI {
    @Override
    public void sendMoney() {
        System.out.println("-----Sending money via YesAdapter Bank----");
    }

    @Override
    public void checkBalance() {
        System.out.println("-----Current Balance in your YesAdapter a/c is 40000.------");
    }
}
