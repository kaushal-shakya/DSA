package lld2.factory.components.abstractfactory.documentprocessig.solved;

import lld2.factory.components.abstractfactory.documentprocessig.solved.parser.DocumentParser;
import lld2.factory.components.abstractfactory.documentprocessig.solved.printer.DocumentPrinter;
import lld2.factory.components.abstractfactory.documentprocessig.solved.printer.TextDocumentPrinter;
import lld2.factory.components.abstractfactory.documentprocessig.solved.processor.DocumentProcessor;
import lld2.factory.components.abstractfactory.documentprocessig.solved.processor.TextDocumentProcessor;


public class TextDocumentFactory extends DocumentFactory {
    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }

    @Override
    public DocumentProcessor createProcessor(String documentName) {
        return new TextDocumentProcessor(documentName);
    }

    @Override
    public DocumentPrinter createPrinter(DocumentProcessor documentProcessor) {
        return new TextDocumentPrinter(documentProcessor);
    }

    @Override
    public DocumentParser createParser(String path) {
        return null;
    }
}
