package lld2.factory.components.simplefactory.documentprocessorsimplefactory.solved;

public class DocumentProcessorFactory {
    public static DocumentProcessor createDocumentProcessors(DocumentType type, String documentName) {
        if(type == DocumentType.TEXT) {
            return new TextDocumentProcessor(documentName);
        } else if(type == DocumentType.SPREAD_SHEET) {
            return new SpreadsheetDocumentProcessor(documentName);
        } else
            return new PresentationDocumentProcessor(documentName);
    }
}
