package lld2.factory.components.abstractfactory.documentprocessig.unsolvedtemplate.parser;

import lld2.factory.components.abstractfactory.documentprocessig.unsolvedtemplate.DocumentType;

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