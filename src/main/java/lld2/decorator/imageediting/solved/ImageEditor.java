package lld2.decorator.imageediting.solved;

import lld2.decorator.imageediting.solved.utils.Image;
import lld2.decorator.imageediting.solved.utils.ImageUtils;

public interface ImageEditor {

    /** Task 1a - Add a method readImage that accepts a filePath and that returns an image {@link decorator.utils.Image}. */
    Image readImage(String filePath);

    String render(Image image);
}
