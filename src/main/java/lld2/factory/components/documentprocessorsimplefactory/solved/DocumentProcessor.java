package lld2.factory.components.documentprocessorsimplefactory.solved;

public abstract class DocumentProcessor {
    protected String documentName;

    public abstract DocumentType supportsType();

    public abstract String getDocumentName();

    public abstract void processDocument();
}
