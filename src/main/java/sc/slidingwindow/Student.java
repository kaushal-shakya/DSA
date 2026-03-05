package sc.slidingwindow;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;

public class Student {
    String name; // Non-Primitive
    int age; // Primitive
    String batch; // Non-Primitive

    Student(String a, int b, String c) {
        name  = a;
        age = b;
        batch = c;
    }

    Student(Student s) {
        this.name = s.name;
        this.age = s.age;
        this.batch = s.batch;
    }
}

class StudentMain {
    public static void main(String[] args) {
        Student st1 = new Student("Kaushal", 30, "August2025");
        Student st2 = new Student("Sweta", 30, "July2025");

    }
}
