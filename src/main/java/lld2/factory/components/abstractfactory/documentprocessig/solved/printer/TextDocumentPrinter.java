package lld2.factory.components.abstractfactory.documentprocessig.solved.printer;

import lld2.factory.components.abstractfactory.documentprocessig.solved.DocumentType;
import lld2.factory.components.abstractfactory.documentprocessig.solved.processor.DocumentProcessor;

public class TextDocumentPrinter extends DocumentPrinter {

    public TextDocumentPrinter(DocumentProcessor processor) {
        super(processor);
    }

    public void printDocument() {
        // Print text document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }
}