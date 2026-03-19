package lld2.factory.components.v2;

import lld2.factory.components.common.buttons.Button;
import lld2.factory.components.common.menu.Menu;

public class Client {
    public static void main(String[] args) {
        Flutter flutter = new Flutter();

        System.out.println("-------IOS--------");
        UIFactory uiFactory = flutter.createUIFactory(SupportedPlatform.IOS);
        Button button = uiFactory.createButton();
        button.clickButton();
        Menu menu = uiFactory.showMenu();
        menu.showMenu();

        System.out.println("-------ANDROID--------");
        UIFactory uiAndroidFactory = flutter.createUIFactory(SupportedPlatform.ANDROID);

        Button button1 = uiAndroidFactory.createButton();;
        button1.clickButton();

        Menu menu1 = uiAndroidFactory.showMenu();
        menu1.showMenu();
    }
}
