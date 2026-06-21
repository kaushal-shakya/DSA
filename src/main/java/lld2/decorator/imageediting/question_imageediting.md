Decorator Pattern for Image Editing Application
===============================================

Problem Statement
-----------------

You are working on an image editing application where users can apply various filters and effects to their images. However, the current implementation of the application is becoming monolithic, with each filter or effect tightly coupled to the main image editor class. Moreover, adding new filters or effects requires modifying the existing code, leading to maintenance issues and potential bugs.

You want to refactor the image editing application to make it more flexible and maintainable. You decide to use the Decorator pattern to allow users to dynamically add filters and effects to images without modifying the existing codebase.

Assignment
----------

Your task is to implement the Decorator pattern to enhance the image editing application. The Decorator pattern allows behavior to be added to individual objects dynamically, without affecting the behavior of other objects of the same class. This pattern is particularly useful when you need to add or modify the behavior of objects at runtime.

### Task 1 - Implement the ImageEditor Interface

You have been provided with a base class named StorageManager, which represents the main image editing functionality. Your first task is to create the ImageEditor interface. You need to complete the ImageEditor interface by adding a method:

*   Add a method render that returns a String representing the image rendering operation.


### Task 2 - Implement the RawImageEditor Class

Next, you need to implement the RawImageEditor class, which is a concrete implementation of the ImageEditor and simply renders the raw image. The tasks are as follows:

*   Implement the ImageEditor interface to render the raw image.


### Task 3 - Implement the BaseImageDecorator Class

Now, you need to implement the BaseImageDecorator abstract class, which is the base class for all decorators. Each decorator should have the same methods as the product it decorates, i.e., render. It also needs to call the next decorator in the chain and finally call the raw image editor. The tasks are as follows:

*   Inherit from the ImageEditor interface.

*   Store a reference to the next layer of type ImageEditor.


### Task 4 - Implement the BlurImageDecorator, SharpenImageDecorator, and GrayscaleImageDecorator Classes

Finally, you need to implement the BlurImageDecorator, SharpenImageDecorator, and GrayscaleImageDecorator classes, which are concrete decorators that add specific filters to the image editing application. The tasks are as follows:

*   Implement the BlurImageDecorator class to apply a blur effect to the image. Use the ImageUtils.applyBlur method for this purpose. Remember to call the next layer in the chain while rendering the image.

*   Implement the SharpenImageDecorator class to apply a sharpen effect to the image. Use the ImageUtils.applySharpen method for this purpose. Remember to call the next layer in the chain while rendering the image.

*   Implement the GrayscaleImageDecorator class to apply a grayscale effect to the image. Use the ImageUtils.applyGrayscale method for this purpose. Remember to call the next layer in the chain while rendering the image.


### Instructions

1.  Create the ImageEditor interface and add the render() method.

2.  Implement the ImageEditor interface in the RawImageEditor class to render the raw image.

3.  Complete the BaseImageDecorator abstract class by implementing the ImageEditor interface and storing a reference to the next layer of type ImageEditor.

4.  Create the BlurImageDecorator class to add a blur effect to the image.

5.  Create the SharpenImageDecorator class to add a sharpen effect to the image.

6.  Create the GrayscaleImageDecorator class to add a grayscale effect to the image.

7.  Run the provided test cases in the TestImageDecorator class to verify the correctness of your implementation. You are not required to edit the test cases themselves.