package lld3.pen;

public class PenClient {
    public static void main(String[] args) {

        Refill refill = new Refill(0.7, "Blue");
        BallPen ballPen = new BallPen(PenState.CLOSED, refill);
        ballPen.write();
        ballPen.setPenState(PenState.OPEN);
        ballPen.write();

        ballPen.refill("red");
        ballPen.write();

        FountainPen fountainPen = new FountainPen(PenState.CLOSED, "black");
        fountainPen.write();
        fountainPen.setPenState(PenState.OPEN);
        fountainPen.write();

    }
}
