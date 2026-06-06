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

        GameConfig gameConfig = gameConfigRegistry.get("Ranked-Erangel").clone();
        gameConfig.setWeatherType("Clear");
        gameConfig.setServerRegion("US");


    }
}
