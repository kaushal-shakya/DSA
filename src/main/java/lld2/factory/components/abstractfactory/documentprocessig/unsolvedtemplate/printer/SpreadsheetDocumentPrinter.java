package lld2.factory.components.abstractfactory.documentprocessig.unsolvedtemplate.printer;

import lld2.factory.components.abstractfactory.documentprocessig.unsolvedtemplate.DocumentType;
import lld2.factory.components.abstractfactory.documentprocessig.unsolvedtemplate.processor.DocumentProcessor;

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
