# Facade Pattern for Image Editing Application

## Problem Statement
You are developing an image editing software that offers various features like:
- Loading images
- Applying filters
- Adjusting brightness
- Saving images

The editing module has complex interactions and dependencies. Your goal is to simplify the interface for users by providing a unified way to access and control these editing functionalities.

## Assignment
Your task is to implement the **Facade pattern** to refactor the existing `ImageEditingManager` class. The class currently handles image editing functionalities separately. Your objective is to create a facade class that presents a unified and simplified interface for users to perform image editing tasks while abstracting away the internal complexities.

## Implementing the Facade Pattern
1. **Review the original class:**
    - Take a closer look at the `ImageEditingManager` class and its methods.
    - Understand how each editing module is handled and the interactions involved.
2. **Create the facade class:**
    - Create a new class named `ImageEditingFacade` that implements the Facade pattern.
    - This class will encapsulate interactions with the image editing module, providing a simplified way to edit images.
3. **Constructor considerations:**
    - Ensure that your `ImageEditingFacade` constructor takes the same arguments as `ImageEditingManager`. This allows passing necessary dependencies.
4. **Test your implementation:**
    - Run provided test cases to verify that your facade works correctly and provides expected functionality.