package lld2.factory.components.v2;

import lld2.factory.components.common.buttons.Button;
import lld2.factory.components.common.menu.Menu;

public interface UIFactory {
    Button createButton();
    Menu showMenu();
}
