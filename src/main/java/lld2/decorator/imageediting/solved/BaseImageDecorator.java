package lld2.decorator.imageediting.solved;


import lld2.decorator.imageediting.solved.utils.Image;
import lld2.decorator.imageediting.solved.utils.ImageUtils;

/**
 * TODO Task 3a - Each decorator should have the same methods as the product it decorates i.e. readImage
 * Inherit from the image editor interface {@link decorator.ImageEditor}.
 */

public class BaseImageDecorator implements ImageEditor {

    private Image image;
    protected ImageEditor imageEditor;

    public BaseImageDecorator() {
        this.imageEditor = null;
    }

    public BaseImageDecorator(ImageEditor imageEditor) {
        this.imageEditor = imageEditor;
    }

    @Override
    public Image readImage(String filePath) {
        return imageEditor.readImage(filePath);
    }

    @Override
    public String render(Image image) {
        return image + imageEditor.render(image);
    }

    /**
     * TODO Task 3b - Each decorator will have to call the next decorator in the chain and finally call the raw image editor.
     * To achieve this, you will need to store a reference to the next layer. Add a field that stores the next layer of
     * type {@link ImageEditor}. This should be protected so that it can be accessed by the subclasses.
     */
}
