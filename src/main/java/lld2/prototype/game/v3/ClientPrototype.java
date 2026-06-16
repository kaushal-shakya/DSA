package lld2.prototype.game.v3;

import java.util.List;

public class ClientPrototype {


    private static GameConfigRegistry gameConfigRegistry = new GameConfigRegistry();

    public static void fillRegistry() {
        GameConfig asiaErangel = new GameConfig();
        asiaErangel.setMap("Erangel");
        asiaErangel.setVersion("3.2.1");
        asiaErangel.setMaxPlayers(3);
        asiaErangel.setGravity(9.8);
        asiaErangel.setWeaponsEnabled(List.of("AK-47", "Bajuka", "SNG", "Shotgun"));
        asiaErangel.setHealthMultiplier(3);
        asiaErangel.setWeatherType("Rainy");
        asiaErangel.setServerRegion("Asia");

        gameConfigRegistry.register("Asia-Erangel", asiaErangel);

        RankedGameConfig rankedErangel = new RankedGameConfig();
        rankedErangel.setMap("Erangel");
        rankedErangel.setVersion("3.2.1");
        rankedErangel.setMaxPlayers(3);
        rankedErangel.setGravity(9.8);
        rankedErangel.setWeaponsEnabled(List.of("AK-47", "Bajuka", "SNG", "Shotgun"));
        rankedErangel.setHealthMultiplier(3);
        rankedErangel.setWeatherType("Rainy");
        rankedErangel.setServerRegion("Asia");
        rankedErangel.setRankedPointMultiplier(4);
        rankedErangel.setAntiCheatEnabled(true);

        gameConfigRegistry.register("Ranked-Erangel", rankedErangel);
    }

    public static void main(String[] args) {
        fillRegistry();


        /**
         * Hides complexities from the client - If you didn't have the Prototype Pattern, the developer writing main would have had to write 9 lines of code (calling setMap, setGravity, setWeaponsEnabled, etc.) just to create the asiaMatch.
         * Furthermore, they would have had to memorize exactly what the Erangel defaults are supposed to be.
         * Because of the Prototype Pattern, all that messy configuration is hidden away in fillRegistry.
         */
        GameConfig gameConfig1 = gameConfigRegistry.get("Asia-Erangel").clone();
        gameConfig1.setWeatherType("Cloudy");
        gameConfig1.setServerRegion("Africa");

        /** Generates objects of unknown types to client
         Registry stores everything as the base GameConfig type.
         The client code thinks it is just dealing with a standard GameConfig.
         It doesn't actually know that it is secretly cloning a RankedGameConfig.
         Because of polymorphism, your .clone() method automatically executes the correct logic for the ranked subclass.
         You successfully duplicated a specific subclass without the client ever needing to use new RankedGameConfig()
         or write instanceof checks. */
        GameConfig gameConfig = gameConfigRegistry.get("Ranked-Erangel").clone();
        gameConfig.setWeatherType("Clear");
        gameConfig.setServerRegion("US");


    }
}
