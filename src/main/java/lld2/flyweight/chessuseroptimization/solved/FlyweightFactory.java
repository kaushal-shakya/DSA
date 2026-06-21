package lld2.flyweight.chessuseroptimization.solved;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory implements FlyweightRegistry {

    private static final Map<String, ChessUserIntrinsicState> CACHE = new HashMap<>();

    @Override
    public void addFlyweight(ChessUserIntrinsicState flyweight) {
        CACHE.put(flyweight.getEmail(), flyweight);
    }

    @Override
    public ChessUserIntrinsicState getFlyweight(String email) {
        return CACHE.get(email);
    }

    
}
