package sc.slidingwindow;

import java.util.ArrayList;

public class User {
    String name;
    String email;
    String password;

    void login() {
        System.out.println("Login successful...");
    }

    void signup() {
        System.out.println("Signing up...");
    }
}

class Mentor extends  User {
    double avgRating;
    String company;
    ArrayList<String> subjects;

    void tech() {
        System.out.println("teaching...");
    }
}

class TA extends  User {
    double avgRating;
    String company;
    ArrayList<String> subjects;

    void tech() {
        System.out.println("teaching...");
    }

//    int login(){return 0;};
}



class Main {
    public static void main(String[] args) {
        TA a = new TA();
        a.login();
    }
}
