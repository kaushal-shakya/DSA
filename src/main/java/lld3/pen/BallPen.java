package lld3.pen;

public class BallPen extends Pen implements Refillable {

    public Refill refill = new Refill();

    BallPen(PenState penState, Refill refill) {
        super(penState);
        super.setPenType(PenType.BALL);
        this.refill.setInk(refill.getInk());
        this.refill.setNibRadius(refill.getNibRadius());
    }

    @Override
    void write() {
        if(getPenState() == PenState.CLOSED) {
            System.out.println("Pen is close, can't write. Please open to use pen.");
            return;
        }
        System.out.println("Writing using ball "+ refill.getInk() + " pen");
    }

    @Override
    public void refill(String ink_color) {
        refill.setInk(ink_color);
        System.out.println("Refilled with : " + ink_color);
    }
}
