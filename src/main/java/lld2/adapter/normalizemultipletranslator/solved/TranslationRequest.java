package lld2.adapter.normalizemultipletranslator.solved;

import lombok.Getter;
import lombok.NoArgsConstructor;

// DO NOT REMOVE THE NO-ARG CONSTRUCTOR ANNOTATION
@NoArgsConstructor
@Getter
public class TranslationRequest {

    private String text;
    private String sourceLanguage;
    private String targetLanguage;
    private Double confidenceThreshold;

    public TranslationRequest(String text,  String sourceLanguage, String targetLanguage, Double confidenceThreshold) {
        this.text = text;
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
        this.confidenceThreshold = confidenceThreshold;
    }
}
