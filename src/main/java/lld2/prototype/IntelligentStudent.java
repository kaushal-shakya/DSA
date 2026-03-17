package lld2.prototype;

public class IntelligentStudent extends Student {
    int iq;

    IntelligentStudent(){}

    IntelligentStudent(IntelligentStudent intelligentStudent) {

    }
    @Override
    public Student clone() {
        return new IntelligentStudent(this);
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    @Override
    public String toString() {
        return "[ Name : " + this.getName() + "\n"
                + "Age : "  + this.getAge() + "\n"
                + "AvgPsp : "  + this.getAvgPsp() + "\n"
                + "Batch : "  + this.getBatch() + "\n"
                + "IQ : "  + this.iq + "\n"
                + " ]";
    }
}
