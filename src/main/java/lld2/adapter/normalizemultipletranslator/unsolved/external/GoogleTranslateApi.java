package lld2.adapter.normalizemultipletranslator.unsolved.external;

import java.util.List;

import static lld2.adapter.normalizemultipletranslator.unsolved.external.ApiUtils.logGoogleGetSupportedLanguages;
import static lld2.adapter.normalizemultipletranslator.unsolved.external.ApiUtils.logGoogleTranslate;

public class GoogleTranslateApi {
    public String convert(GoogleTranslationRequest request) {
        // Implementation for translating text using Google Translate API
        logGoogleTranslate();
        return "Translated text";
    }

    public List<String> getLanguages() {
        // Implementation for fetching supported languages from Google Translate
        logGoogleGetSupportedLanguages();
        return List.of("hindi", "marathi", "kannada");
    }
}
