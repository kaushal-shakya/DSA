package lld2.factory.components.deepak_rec.v2;

import lld2.factory.components.deepak_rec.common.buttons.Button;
import lld2.factory.components.deepak_rec.common.buttons.IOSButton;
import lld2.factory.components.deepak_rec.common.menu.IOSMenu;
import lld2.factory.components.deepak_rec.common.menu.Menu;

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
