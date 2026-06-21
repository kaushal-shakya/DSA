package lld2.decorator.imageediting.solved;

import lld2.decorator.imageediting.solved.utils.Image;
import lld2.decorator.imageediting.solved.utils.ImageUtils;

/**
 * TODO Task 4a - Extend the {@link BaseImageDecorator} interface to convert the image to grayscale.
 * Remember
 * 1. When you inherit from the {@link BaseImageDecorator}, you will have to implement the readImage method.
 * 2. You will also need to call the next layer from {@link BaseImageDecorator} in the chain to get the image and then convert it to grayscale.
 * 3. Each decorator would also need a constructor that takes the next layer of type {@link ImageEditor} and calls the super constructor.
 */
public class GrayscaleImageDecorator extends BaseImageDecorator {

    protected ImageEditor imageEditor;

    public GrayscaleImageDecorator(ImageEditor imageEditor) {
        super(imageEditor);
    }

    @Override
    public Image readImage(String filePath) {
        return ImageUtils.read(filePath);
    }

    @Override
    public String render(Image image) {
        ImageUtils.convertToGrayscale(image);
        return "";
    }
}
