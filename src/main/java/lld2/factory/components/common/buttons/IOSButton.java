package lld2.factory.components.common.buttons;

public class IOSButton implements Button{
    @Override
    public void clickButton() {
        System.out.println("IOS Button clicked.");
    }
}
