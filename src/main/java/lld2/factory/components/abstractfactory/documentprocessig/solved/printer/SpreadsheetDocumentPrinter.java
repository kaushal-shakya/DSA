package lld2.factory.components.abstractfactory.documentprocessig.solved.printer;

import lld2.factory.components.abstractfactory.documentprocessig.solved.DocumentType;
import lld2.factory.components.abstractfactory.documentprocessig.solved.processor.DocumentProcessor;

public class SpreadsheetDocumentPrinter extends DocumentPrinter {

    public SpreadsheetDocumentPrinter(DocumentProcessor processor) {
        super(processor);
    }

    public void printDocument() {
        // Print spreadsheet document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }
}
