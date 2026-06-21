package lld2.decorator.imageediting.solved;

import lld2.decorator.imageediting.solved.utils.Image;

/**
 * TODO Task 4a - Extend the {@link BaseImageDecorator} interface to convert the image to grayscale.
 * Remember
 * 1. When you inherit from the {@link BaseImageDecorator}, you will have to implement the readImage method.
 * 2. You will also need to call the next layer from {@link BaseImageDecorator} in the chain to get the image and then convert it to grayscale.
 * 3. Each decorator would also need a constructor that takes the next layer of type {@link ImageEditor} and calls the super constructor.
 */
public class GrayscaleImageDecorator implements ImageEditor {

    protected ImageEditor imageEditor;

    GrayscaleImageDecorator(ImageEditor imageEditor) {
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
