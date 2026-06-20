package lld2.prototype.configobjectcloning.solved;

import lld2.prototype.invoicegeneration.solved.ClonableObject;

public class Configuration implements ClonableObject<Configuration> {
    private String themeColor;
    private Boolean autoSave;
    private String language;
    private Boolean darkMode;
    private Integer fontSize;
    private String fontFamily;
    private ConfigurationType type;

    public Configuration(Configuration originalConfig) {
        this.themeColor = originalConfig.themeColor;
        this.autoSave = originalConfig.autoSave;
        this.language = originalConfig.language;
        this.darkMode = originalConfig.darkMode;
        this.fontSize = originalConfig.fontSize;
        this.fontFamily = originalConfig.fontFamily;
        this.type = originalConfig.type;
    }

    public Configuration(String themeColor, Boolean autoSave, String language, Boolean darkMode, Integer fontSize, String fontFamily, ConfigurationType type) {
        this.themeColor = themeColor;
        this.autoSave = autoSave;
        this.language = language;
        this.darkMode = darkMode;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        this.type = type;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public Boolean getAutoSave() {
        return autoSave;
    }

    public String getLanguage() {
        return language;
    }

    public Boolean getDarkMode() {
        return darkMode;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public ConfigurationType getType() {
        return type;
    }

    @Override
    public Configuration cloneObject() {
        return new Configuration(this);
    }
}