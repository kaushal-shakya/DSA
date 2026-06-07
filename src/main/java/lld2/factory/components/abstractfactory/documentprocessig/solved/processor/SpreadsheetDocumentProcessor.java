package lld2.factory.components.abstractfactory.documentprocessig.solved.processor;

import lld2.factory.components.abstractfactory.documentprocessig.solved.DocumentType;

public class SpreadsheetDocumentProcessor extends DocumentProcessor {

    public SpreadsheetDocumentProcessor(String documentName) {
        super(documentName);
    }

    @Override
    public void processDocument() {
        // Implement spreadsheet document processing logic
        System.out.println("Processing a spreadsheet document: " + getDocumentName());
        // Additional logic for spreadsheet document processing
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }

    public void performDataAnalysis() {
        System.out.println("Performing data analysis on the spreadsheet.");
    }
}