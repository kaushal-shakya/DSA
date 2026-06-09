package lld2.adapter.normalizemultipletranslator.solved;

import lld2.adapter.normalizemultipletranslator.solved.external.GoogleTranslateApi;
import lld2.adapter.normalizemultipletranslator.solved.external.GoogleTranslationRequest;

import java.util.List;

public class GoogleTranslateImpl implements TranslationProviderAdapter{

    GoogleTranslateApi api ;

    public GoogleTranslateImpl() {
        this.api = new GoogleTranslateApi();
    }

    @Override
    public String translate(TranslationRequest request) {
        return api.convert(new GoogleTranslationRequest(request.getText(), request.getSourceLanguage(), request.getTargetLanguage(), request.getConfidenceThreshold()));
    }

    @Override
    public List<String> getSupportedLanguages() {
        return api.getLanguages();
    }
}
