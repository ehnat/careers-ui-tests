package com.akamai.configuration;

import static com.akamai.configuration.Configuration.CONFIGURATION;

public enum OperatingSystem {
    WIN(CONFIGURATION.getValue("pathToChromeDriverWin")),
    MAC(CONFIGURATION.getValue("pathToChromeDriverMac"));

    private String chromeDriverPath;

    OperatingSystem(String chromeDriverPath) {
        this.chromeDriverPath = chromeDriverPath;
    }

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }
}
