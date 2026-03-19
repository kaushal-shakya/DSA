package lld2.factory.components.v2;

import lld2.factory.components.common.buttons.Button;
import lld2.factory.components.common.buttons.IOSButton;
import lld2.factory.components.common.menu.IOSMenu;
import lld2.factory.components.common.menu.Menu;

public class IOSUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Menu showMenu() {
        return new IOSMenu();
    }
}
