package lld2.adapter.normalizemultipletranslator.solved;

import lld2.adapter.normalizemultipletranslator.solved.external.MicrosoftTranslateApi;

import java.util.List;

public class MicrosoftTranslateImpl implements TranslationProviderAdapter{

    MicrosoftTranslateApi api;

    public MicrosoftTranslateImpl() {
        this.api = new MicrosoftTranslateApi();
    }

    @Override
    public String translate(TranslationRequest request) {
//        return api.translate();
        return api.translate(request.getText(), request.getSourceLanguage(), request.getTargetLanguage());
    }

    @Override
    public List<String> getSupportedLanguages() {
        return api.getSupportedLanguages();
    }
}
