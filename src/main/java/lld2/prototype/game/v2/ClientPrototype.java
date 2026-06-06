package lld2.prototype.game.v2;

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
        System.out.println("Asia Region Game Config : " + config1);

        GameConfig config2 = config1.clone();
        config2.setServerRegion("Europe");
        System.out.println("Europe Region Game Config : " + config2);


        RankedGameConfig original = new RankedGameConfig();
        original.setMap("Erangel");
        original.setVersion("3.4.2");
        original.setGravity(9.8);
        original.setMaxPlayers(8);

        RankedGameConfig rankedGameConfig = original.clone();

/***
 * Problems without Registry pattern
 * 1. Client must know how to create prototypes
 *      -> Imagine configuration requires 50 fields.
 * 2. Duplicate initialization logic
 * 3. Hard to manage predefined templates
 * 4. Difficult to add new prototype types
 * 5. Prototype loses some of its "factory-like" benefit
 */

    }
}
