package lld2.flyweight.chessuseroptimization.unsolved;

public interface FlyweightRegistry {
    void addFlyweight(UserIntrinsicState flyweight);

    UserIntrinsicState getFlyweight(String email);
}
