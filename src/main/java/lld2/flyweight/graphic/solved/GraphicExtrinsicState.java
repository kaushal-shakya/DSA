package lld2.flyweight.graphic.solved;

import lombok.Getter;

@ExtrinsicState
@Getter
public class GraphicExtrinsicState {
    
    private GraphicType type;
    private int x;
    private int y;

    private final GraphicIntrinsicState graphicIntrinsicState;

    public GraphicExtrinsicState(GraphicIntrinsicState graphicIntrinsicState, int x, int y, int width, int height) {
        this.graphicIntrinsicState = graphicIntrinsicState;
        this.x = x;
        this.y = y;
    }
}