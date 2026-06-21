package lld2.decorator.filestorageservice.unsolved;

/**
 * TODO Task 4b - Extend the {@link BaseFileDecorator} interface to scan the file content for viruses before storing and reading the file content.
 * Remember
 * 1. When you inherit from the {@link BaseFileDecorator}, you will have to implement the store and read methods.
 * 2. You will also need to call the next layer in the chain while reading and writing the file content.
 * 3. Each decorator would also need a constructor that takes the next layer of type {@link FileStorage}.
 */
public class VirusScanningDecorator {
}
