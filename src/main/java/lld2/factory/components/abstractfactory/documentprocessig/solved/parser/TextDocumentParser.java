package lld2.factory.components.abstractfactory.documentprocessig.solved.parser;

import lld2.factory.components.abstractfactory.documentprocessig.solved.DocumentType;

public class TextDocumentParser extends DocumentParser {

    public TextDocumentParser(String path) {
        super(path);
    }

    public void parseDocument() {
        // Parse text document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }
}