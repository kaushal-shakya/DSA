package lld2.facade.imageediting.solved;

import lld2.facade.imageediting.solved.models.Image;
import lld2.facade.imageediting.solved.services.*;

public class ImageEditingManager {

    private ImageEditingFacade facade;

    public ImageEditingManager(ImageLoader imageLoader, FilterService filterService, ImageModifier imageModifier, ImageWriter imageWriter, AnalyticsService analyticsService) {
        facade = new ImageEditingFacade(imageLoader, filterService, imageModifier, imageWriter, analyticsService);
    }

    public void editImage(String imagePath, String filterType, int brightness) {
         facade.editImage(imagePath, filterType, brightness);
    }

}