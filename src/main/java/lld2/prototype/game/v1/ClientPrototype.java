package lld2.prototype.game.v1;

import java.util.ArrayList;
import java.util.List;

public class ClientPrototype {
    public static void main(String[] args) {
        GameConfig config1 = new GameConfig();
        config1.setMap("Erangel");
        config1.setVersion("3.2.1");
        config1.setMaxPlayers(3);
        config1.setGravity(9.8);
        config1.setWeaponsEnabled(List.of("AK-47", "Bajuka", "SNG", "Shotgun"));
        config1.setHealthMultiplier(3);
        config1.setWeatherType("Rainy");
        config1.setServerRegion("Asia");

        //Naive Copying -- copying each field manually from the original config
        GameConfig config2 = new GameConfig();
        config2.setMap(config1.getMap());
        config2.setVersion(config1.getMap());
        config2.setWeaponsEnabled(new ArrayList<>(config1.getWeaponsEnabled()));

        /**
         * Problems with this approach
         * 1. Tight coupling -> I need to know each and every attribute of Game config - violates encapsulation
         * 2. Repetitive code
         * 3. Fragile to change --> Add a new attribute requires to manually copy new attribute in all the config manually
         * 4. prone to errors
         */
    }
}
