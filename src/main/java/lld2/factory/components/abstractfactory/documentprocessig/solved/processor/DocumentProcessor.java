package lld2.factory.components.abstractfactory.documentprocessig.solved.processor;

import lld2.factory.components.abstractfactory.documentprocessig.solved.DocumentType;

public abstract class DocumentProcessor {
    private String documentName;

    public DocumentProcessor(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentName() {
        return documentName;
    }

    public abstract void processDocument();

    public abstract DocumentType supportsType();

}
