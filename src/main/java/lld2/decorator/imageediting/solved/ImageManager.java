package lld2.decorator.imageediting.solved;

import lld2.decorator.imageediting.solved.utils.Image;
import lld2.decorator.imageediting.solved.utils.ImageUtils;

public class ImageManager {

    public Image readImage(String filePath, boolean enableGrayscale, boolean enableBlur) {

        Image image = ImageUtils.read(filePath);
        if (enableGrayscale) {
            image = ImageUtils.convertToGrayscale(image);
        }

        if (enableBlur) {
            image = ImageUtils.applyBlur(image);
        }

        return image;
    }
}
