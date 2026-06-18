package lld3.pen;

public class FountainPen extends Pen {

    private String ink;
    private double nibRadius;

    FountainPen(PenState penState, String ink){
        super(penState);
        this.ink = ink;
    }

    @Override
    void write() {
        if(getPenState() == PenState.CLOSED) {
            System.out.println("Pen is close, can't write. Please open to use pen.");
            return;
        }
        System.out.println("Writing using ball "+ ink + " pen");
    }
}
