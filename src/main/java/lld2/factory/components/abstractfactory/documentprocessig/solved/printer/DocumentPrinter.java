package lld2.factory.components.abstractfactory.documentprocessig.solved.printer;

import lld2.factory.components.abstractfactory.documentprocessig.solved.DocumentType;
import lld2.factory.components.abstractfactory.documentprocessig.solved.processor.DocumentProcessor;

public abstract class DocumentPrinter {

    private final DocumentProcessor processor;

    public DocumentPrinter(DocumentProcessor processor) {
        this.processor = processor;
    }

    public DocumentProcessor getProcessor() {
        return processor;
    }

    public abstract void printDocument();

    public abstract DocumentType supportsType();

}
