package lld3.pen;

public abstract class Pen {
//    private String name;
    private String brand;
    private double price;
    private PenType penType;
    private CloseType closeType;
    private PenState penState;

    public Pen(PenState penState) {
        this.penState = penState;
    }

    abstract void write();

    void open(){
        penState = PenState.OPEN;
        System.out.println("open pen");
    }

    void close() {
        penState = PenState.CLOSED;
        System.out.println("close pen");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PenType getPenType() {
        return penType;
    }

    public void setPenType(PenType penType) {
        this.penType = penType;
    }

    public CloseType getCloseType() {
        return closeType;
    }

    public void setCloseType(CloseType closeType) {
        this.closeType = closeType;
    }

    public PenState getPenState() {
        return penState;
    }

    public void setPenState(PenState penState) {
        this.penState = penState;
    }
}
