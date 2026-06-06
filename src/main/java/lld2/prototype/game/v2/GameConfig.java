package lld2.prototype.game.v2;

import java.util.ArrayList;
import java.util.List;

public class GameConfig implements Prototype<GameConfig> {
    private String map;
    private String version;
    private int maxPlayers;
    private List<String> weaponsEnabled;
    private String weatherType;
    private double gravity;
    private double healthMultiplier;
    private String serverRegion;

    public GameConfig(){}

    /// copy const - engine behind the clone() method
    public GameConfig(GameConfig original) {
        this.map = original.map;
        this.version = original.version;
        this.maxPlayers = original.maxPlayers;
//        this.weaponsEnabled = original.weaponsEnabled; /** shallow copy */
        this.weaponsEnabled = new ArrayList<>(original.weaponsEnabled); /** deep copy */
        this.weatherType = original.weatherType;
        this.gravity = original.gravity;
        this.healthMultiplier = original.healthMultiplier;
        this.serverRegion = original.serverRegion;
    }

    @Override
    public GameConfig clone() {
        return new GameConfig(this);
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public List<String> getWeaponsEnabled() {
        return weaponsEnabled;
    }

    public void setWeaponsEnabled(List<String> weaponsEnabled) {
        this.weaponsEnabled = weaponsEnabled;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public double getHealthMultiplier() {
        return healthMultiplier;
    }

    public void setHealthMultiplier(double healthMultiplier) {
        this.healthMultiplier = healthMultiplier;
    }

    public String getServerRegion() {
        return serverRegion;
    }

    public void setServerRegion(String serverRegion) {
        this.serverRegion = serverRegion;
    }

    @Override
    public String toString() {
        return "\nGameConfig{" +
                "\nmap='" + map + '\'' +
                "\n, version='" + version + '\'' +
                "\n, maxPlayers=" + maxPlayers +
                "\n, weaponsEnabled=" + weaponsEnabled +
                "\n, weatherType='" + weatherType + '\'' +
                "\n, gravity=" + gravity +
                "\n, healthMultiplier=" + healthMultiplier +
                "\n, serverRegion='" + serverRegion + '\'' +
                '}';
    }
}
