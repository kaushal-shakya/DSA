package lld2.flyweight.graphic.solved;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory implements FlyweightRegistry {

    private Map<GraphicType, GraphicIntrinsicState> CACHE = new HashMap<>();

    @Override
    public void addFlyweight(GraphicIntrinsicState flyweight) {
        // TODO Auto-generated method stub
        CACHE.put(flyweight.getType(), flyweight);
    }

    @Override
    public GraphicIntrinsicState getFlyweight(GraphicType graphicType) {
        return CACHE.get(graphicType);
    }
    
}
