package lld1.lec1.lab2;

/*
Requirements:
Every employee has: Employee ID (unique)
Name
Email
Department
Salary
Years of experience An employee can: Get a promotion (increase salary by a given percentage)
Change department
Display their details Create at least 3 employee objects and demonstrate all behaviors.
*/

public class Employee {
    int employeeId;
    String name;
    String email;
    String department;
    double salary;
    int experience;

    double promoted(int increament) {
                salary = salary + (((double) increament /100) * salary);
                return salary;
    }

    String changeDept(String newDept) {
        return department = newDept;
    }

    String displayEmployeeInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                '}';
    }
}
