package lld2.factory.components.deepak_rec.v2;

import lld2.factory.components.deepak_rec.common.buttons.AndroidButton;
import lld2.factory.components.deepak_rec.common.buttons.Button;
import lld2.factory.components.deepak_rec.common.menu.AndroidMenu;
import lld2.factory.components.deepak_rec.common.menu.Menu;

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
