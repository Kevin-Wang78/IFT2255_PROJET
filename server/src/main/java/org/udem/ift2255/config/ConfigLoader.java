package org.udem.ift2255.config;


import tools.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class ConfigLoader {
    public static final String API_URL;
    public static final String CLIENT_APP_URL;

    static {
        YAMLMapper mapper = YAMLMapper.builder().build();
        try {
            ApiConfig cfgApi = mapper.readValue(
                    ConfigLoader.class.getResourceAsStream("/application.yml"),
                    ApiConfig.class
            );
            API_URL = cfgApi.getBaseUrls().get("udem");

            AppConfig cfgApp = mapper.readValue(
                    ConfigLoader.class.getResourceAsStream("/application.yml"),
                    AppConfig.class
            );
            CLIENT_APP_URL = cfgApp.getClientSideUrls();
        } catch (Exception e) {
            throw new RuntimeException("Configuration file loading failed", e);
        }
    }

    public static class ApiConfig {
        private Map<String, String> baseUrls;
        public Map<String, String> getBaseUrls() { return baseUrls; }
        public void setBaseUrls(Map<String, String> v) { this.baseUrls = v; }
    }
    public static class AppConfig {
        private String clientSideUrls;
        public String getClientSideUrls() { return clientSideUrls; }
        public void setClientSideUrls(String v) { this.clientSideUrls = v; }
    }
}
