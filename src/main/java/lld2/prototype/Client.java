package lld2.prototype;

public class Client {

    public static void fillRegistry(StudentRegistry registry) {
        Student lldMWFEveningBatch  = new Student();
        lldMWFEveningBatch.setBatch("LLD MWF Evening Batch");
        lldMWFEveningBatch.setAvgPsp(90.00);

        registry.put("lldEvenPrototype", lldMWFEveningBatch);

        IntelligentStudent intelligentStudentRegistry = new IntelligentStudent();
        intelligentStudentRegistry.setBatch("Intelligent Batch");
        intelligentStudentRegistry.setAvgPsp(95.7);

        registry.put("intelligentStudentPrototype", intelligentStudentRegistry);
    }

    public static void main(String[] args) {
        StudentRegistry studentRegistry = new StudentRegistry();
        fillRegistry(studentRegistry);

        Student lldEvenStudent = studentRegistry.get("lldEvenPrototype").clone();
        lldEvenStudent.setName("Kaushal");

        System.out.println(lldEvenStudent.toString());

        Student  sweta = studentRegistry.get("intelligentStudentPrototype").clone();
        sweta.setName("Sweta");
        ((IntelligentStudent)sweta).setIq(100);

        System.out.println(sweta.toString());
    }
}
