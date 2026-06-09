package lld2.adapter.normalizemultipletranslator.solved;

import java.util.List;

public interface TranslationProviderAdapter {
    String translate(TranslationRequest request);
    List<String> getSupportedLanguages();
}
