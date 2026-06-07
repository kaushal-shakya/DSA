package lld2.factory.components.abstractfactory.documentprocessig.unsolvedtemplate.printer;

import lld2.factory.components.abstractfactory.documentprocessig.unsolvedtemplate.DocumentType;
import lld2.factory.components.abstractfactory.documentprocessig.unsolvedtemplate.processor.DocumentProcessor;

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
