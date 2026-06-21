package lld2.flyweight.chessuseroptimization.solved;

public interface FlyweightRegistry {

    void addFlyweight(ChessUserIntrinsicState flyweight);

    ChessUserIntrinsicState getFlyweight(String email);
}