package lld2.builder;

public class Client {
    public static void main(String[] args) {
        Student s = Student.getBuilder()
                .setName("ABC")
                .setAge(30)
                .setBatch("LLD2")
                .setPsp(92.23)
                .setGradeYear(2023)
                .build();

        System.out.println("[ " + s.getName() + " " + s.getAge() + " " + s.getBatch() + " " + s.getPsp() + " " + s.getGradeYear() + " ]");
    }
}
