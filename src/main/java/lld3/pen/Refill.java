package lld3.pen;

public class Refill  {

    private double nibRadius;
    private String ink;

    Refill (){}
    Refill(double nibRadius, String ink) {
        this.nibRadius = nibRadius;
        this.ink = ink;
    }

    public double getNibRadius() {
        return nibRadius;
    }

    public void setNibRadius(double nibRadius) {
        this.nibRadius = nibRadius;
    }

    public String getInk() {
        return ink;
    }

    public void setInk(String ink) {
        this.ink = ink;
    }
}
