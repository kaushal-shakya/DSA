package lld2.factory.components.v2;

import lld2.factory.components.common.buttons.AndroidButton;

public class Flutter {

    // Non-factory methods ---------
    public void refreshUI() {
        System.out.println("Refreshing UI.");
    }

    // Create a factory method to get the corresponding UIFactory object.
    public UIFactory createUIFactory(SupportedPlatform platform) {
        if(platform.equals(SupportedPlatform.ANDROID)) {
            return new AndroidUIFactory();
        } else if (platform.equals(SupportedPlatform.IOS)) {
            return new IOSUIFactory();
        }
        return null;
    }
}
