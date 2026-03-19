package lld2.factory.components.v1;

import lld2.factory.components.common.buttons.AndroidButton;
import lld2.factory.components.common.buttons.Button;
import lld2.factory.components.common.buttons.IOSButton;
import lld2.factory.components.common.menu.AndroidMenu;
import lld2.factory.components.common.menu.IOSMenu;

public class Flutter {
    // Non-factory methods ---------
    public void refreshUI() {
        System.out.println("Refreshing UI.");
    }

//
//    // Factory methods ------- Not a good way to
//    Button createButton() {
//        if(platform is Android) {
//            return new AndroidButton();
//        } else if (platform is IOS) {
//            return new IOSButton();
//        }
//    }
//
//    Menu createMenu() {
//        if(plaform is Android) {
//            return new AndroidMenu();
//        } else if ( platform is IOS) {
//            return new IOSMenu();
//        }
//    }

    Button createButton() {
        return new AndroidButton();
    }
}
