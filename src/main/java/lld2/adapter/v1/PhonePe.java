package lld2.adapter.v1;

import lld2.adapter.common.CommonBankAPI;
import lld2.adapter.common.ICICIAdapter;
import lld2.adapter.common.YesAdapter;

public class PhonePe {
    public static CommonBankAPI getBank(String type) {
        if(type.equalsIgnoreCase("ICICIAdapter"))
            return new ICICIAdapter();
        else if(type.equalsIgnoreCase("yes")) {
            return new YesAdapter();
        }
        return null;
    }
}
