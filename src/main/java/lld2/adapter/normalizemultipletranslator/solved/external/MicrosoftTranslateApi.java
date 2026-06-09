package lld2.adapter.normalizemultipletranslator.solved.external;

import java.util.List;

import static lld2.adapter.normalizemultipletranslator.unsolved.external.ApiUtils.logMicrosoftGetSupportedLanguages;
import static lld2.adapter.normalizemultipletranslator.unsolved.external.ApiUtils.logMicrosoftTranslate;

public class MicrosoftTranslateApi {
    public String translate(String text, String sourceLanguage, String targetLanguage) {
        // Implementation for translating text using Microsoft Translator API
        logMicrosoftTranslate();
        return "Translated text";
    }

    // Method to retrieve the list of supported languages from Microsoft Translator
    public List<String> getSupportedLanguages() {
        // Implementation for fetching supported languages from Microsoft Translator
        logMicrosoftGetSupportedLanguages();
        return List.of("hindi", "marathi", "kannada");
    }
}
