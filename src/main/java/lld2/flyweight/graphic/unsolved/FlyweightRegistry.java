package lld2.flyweight.graphic.unsolved;

public interface FlyweightRegistry {
    void addFlyweight(GraphicIntrinsicState flyweight);

    GraphicIntrinsicState getFlyweight(GraphicType graphicType);
}
