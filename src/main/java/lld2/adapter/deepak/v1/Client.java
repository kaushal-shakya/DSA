package lld2.adapter.deepak.v1;

import lld2.adapter.deepak.common.CommonBankAPI;

public class Client {
    public static void main(String[] args) {
        CommonBankAPI phonePe = PhonePe.getBank("yeS");
        phonePe.checkBalance();
        phonePe.sendMoney();
    }
}
