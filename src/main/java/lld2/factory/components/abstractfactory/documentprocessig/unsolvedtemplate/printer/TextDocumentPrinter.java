package lld2.factory.components.abstractfactory.documentprocessig.unsolvedtemplate.printer;

import lld2.factory.components.abstractfactory.documentprocessig.unsolvedtemplate.DocumentType;
import lld2.factory.components.abstractfactory.documentprocessig.unsolvedtemplate.processor.DocumentProcessor;

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