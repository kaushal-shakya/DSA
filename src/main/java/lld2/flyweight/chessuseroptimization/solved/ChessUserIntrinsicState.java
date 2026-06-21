package lld2.flyweight.chessuseroptimization.solved;

import lombok.Getter;

@IntrinsicState
@Getter
public class ChessUserIntrinsicState {
    private String name;
    private int age;
    private String gender;
    private String email;
    private String phoneNumber;
    private Byte[] photo;

    public ChessUserIntrinsicState(String name, int age, String gender, String email, String phoneNumber, Byte[] photo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.photo = photo;
    }
}