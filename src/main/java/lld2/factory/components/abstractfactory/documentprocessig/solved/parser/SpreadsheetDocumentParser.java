package lld2.factory.components.abstractfactory.documentprocessig.solved.parser;

import lld2.factory.components.abstractfactory.documentprocessig.solved.DocumentType;

public class SpreadsheetDocumentParser extends DocumentParser {

    public SpreadsheetDocumentParser(String path) {
        super(path);
    }

    public void parseDocument() {
        // Parse spreadsheet document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }
}