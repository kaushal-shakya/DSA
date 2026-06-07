package lld2.factory.components.abstractfactory.documentprocessig.solved;

import lld2.factory.components.abstractfactory.documentprocessig.solved.parser.DocumentParser;
import lld2.factory.components.abstractfactory.documentprocessig.solved.printer.DocumentPrinter;
import lld2.factory.components.abstractfactory.documentprocessig.solved.processor.DocumentProcessor;

public abstract class DocumentFactory {
    public abstract DocumentType supportsType();

    public abstract DocumentProcessor createProcessor(String documentName);

    public abstract DocumentPrinter createPrinter(DocumentProcessor documentProcessor);

    public abstract DocumentParser createParser(String path);
}
