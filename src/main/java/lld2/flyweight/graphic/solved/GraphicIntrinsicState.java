package lld2.flyweight.graphic.solved;

import lombok.Getter;

@IntrinsicState
@Getter
public class GraphicIntrinsicState {
    
    GraphicType type;
    private Image image;
    private int width, height;
    private String color;

    public GraphicIntrinsicState(int width, int height, Image image, String color, GraphicType type) {
        this.color = color;
        this.image = image;
        this.width = width;
        this.height = height;
        this.type = type;
    }
}