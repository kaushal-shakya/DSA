package lld2.builder;

import java.time.LocalDate;

public class Student {
    private String name;
    private String batch;
    private int age;
    private double psp;
    private int gradeYear;

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.batch  = builder.batch;
        this.psp = builder.psp;
        this.gradeYear = builder.gradeYear;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String batch;
        private int age;
        private double psp;
        private int gradeYear;

        private Builder(){}

        public Student build(){
            if(this.age < 18) {
                throw new RuntimeException("Age should be less than 18.");
            }
            if(this.gradeYear > LocalDate.now().getYear()) {
                throw new RuntimeException("Graduation Year can't be in future.");
            }
            return new Student(this);
        }

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public String getBatch() {
            return batch;
        }

        public Builder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public Builder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public int getGradeYear() {
            return gradeYear;
        }

        public Builder setGradeYear(int gradeYear) {
            this.gradeYear = gradeYear;
            return this;
        }
    }

    public String getName() {
        return name;
    }

    public String getBatch() {
        return batch;
    }

    public int getAge() {
        return age;
    }

    public double getPsp() {
        return psp;
    }

    public int getGradeYear() {
        return gradeYear;
    }
}



