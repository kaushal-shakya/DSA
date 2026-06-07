package lld2.factory.components.abstractfactory.documentprocessig.solved;

import lld2.factory.components.abstractfactory.documentprocessig.solved.parser.DocumentParser;
import lld2.factory.components.abstractfactory.documentprocessig.solved.parser.SpreadsheetDocumentParser;
import lld2.factory.components.abstractfactory.documentprocessig.solved.printer.DocumentPrinter;
import lld2.factory.components.abstractfactory.documentprocessig.solved.printer.SpreadsheetDocumentPrinter;
import lld2.factory.components.abstractfactory.documentprocessig.solved.processor.DocumentProcessor;
import lld2.factory.components.abstractfactory.documentprocessig.solved.processor.SpreadsheetDocumentProcessor;

public class SpreadsheetDocumentFactory extends DocumentFactory {
    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }

    @Override
    public DocumentProcessor createProcessor(String documentName) {
        return new SpreadsheetDocumentProcessor(documentName);
    }

    @Override
    public DocumentPrinter createPrinter(DocumentProcessor documentProcessor) {
        return new SpreadsheetDocumentPrinter(documentProcessor);
    }

    @Override
    public DocumentParser createParser(String path) {
        return new SpreadsheetDocumentParser(path);
    }
}
