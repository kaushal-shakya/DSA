package lld2.factory.components.abstractfactory.documentprocessig.unsolvedtemplate.parser;

import lld2.factory.components.abstractfactory.documentprocessig.unsolvedtemplate.DocumentType;

public abstract class DocumentParser {

    private final String path;

    public DocumentParser(String path) {
        this.path = path;
    }

    public abstract void parseDocument();

    public String getPath() {
        return path;
    }

    public abstract DocumentType supportsType();
}
