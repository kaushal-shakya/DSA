package lld2.decorator.imageediting.solved;


import lld2.decorator.imageediting.solved.utils.Image;
import lld2.decorator.imageediting.solved.utils.ImageUtils;

/**
 * TODO Task 4a - Extend the {@link BaseImageDecorator} interface to apply a blur filter to the image.
 * Remember
 * 1. When you inherit from the {@link BaseImageDecorator}, you will have to implement the readImage method.
 * 2. You will also need to call the next layer from {@link BaseImageDecorator} in the chain to get the image and then apply the blur filter.
 * 3. Each decorator would also need a constructor that takes the next layer of type {@link ImageEditor} and calls the super constructor.
 */
public class BlurImageDecorator implements ImageEditor {

    protected ImageEditor imageEditor;

    BlurImageDecorator(ImageEditor imageEditor){
        this.imageEditor = imageEditor;
    }

    @Override
    public Image readImage(String filePath) {
        return null;
    }

    @Override
    public String render(Image image) {
        return "";
    }
}
