package lld2.prototype.game.v3;

import java.util.Map;

public class GameConfigRegistry {
    private Map<String, GameConfig> registry;

    public void register(String key, GameConfig registerObj) {
        registry.put(key, registerObj);
    }

    public GameConfig get(String key) {
        return registry.get(key);
    }
}
