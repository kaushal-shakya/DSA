package lld2.factory.components.v2;

import lld2.factory.components.common.buttons.AndroidButton;
import lld2.factory.components.common.buttons.Button;
import lld2.factory.components.common.menu.AndroidMenu;
import lld2.factory.components.common.menu.Menu;

public class AndroidUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu showMenu() {
        return new AndroidMenu();
    }
}
