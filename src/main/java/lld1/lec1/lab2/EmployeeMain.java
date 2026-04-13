package lld1.lec1.lab2;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.name = "A";
        e1.email= "test1@gmai.com";
        e1.department = "Finance";
        e1.salary = 10000.00;
        e1.experience = 4;

        Employee e2 = new Employee();
        e2.name = "B";
        e2.email= "test2@gmai.com";
        e2.department = "Infra";
        e2.salary = 10000.00;
        e2.experience = 4;

        Employee e3 = new Employee();
        e3.name = "C";
        e3.email= "test3@gmai.com";
        e3.department = "IT";
        e3.salary = 14000.00;
        e3.experience = 4;

        System.out.println(e3.displayEmployeeInfo());
        e3.changeDept("DBA");
        e3.promoted(-10);
        System.out.println(e3.displayEmployeeInfo());

    }
}
