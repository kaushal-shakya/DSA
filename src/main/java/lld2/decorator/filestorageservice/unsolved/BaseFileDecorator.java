package lld2.decorator.filestorageservice.unsolved;

import lombok.AllArgsConstructor;

/**
 * TODO Task 3a - Each decorator should have the same methods as the product it decorates i.e. store and read.
 * Inherit from the file storage interface {@link contest.FileStorage}.
 */
@AllArgsConstructor
public abstract class BaseFileDecorator {

    /**
     * TODO Task 3b - Each decorator will have to call the next decorator in the chain and finally call the raw file storage.
     * To achieve this, you will need to store a reference to the next layer. Add a field that stores the next layer of
     * type {@link contest.FileStorage}.
     */
}
