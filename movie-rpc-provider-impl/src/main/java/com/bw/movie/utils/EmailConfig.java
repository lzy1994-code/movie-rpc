package com.bw.movie.utils;

import java.io.IOException;
import java.util.Properties;

public class EmailConfig {

    private String from;
    private String user;
    private String pwd;
    private String host;

    private static EmailConfig emailConfig = null;

    public static EmailConfig initConfig() {
        if (emailConfig != null) {
            return emailConfig;
        } else {
            try {
                Properties properties = PropertiesUtil.getProperties("properties/email_config.properties", "utf-8");
                emailConfig = new EmailConfig();
                emailConfig.from = properties.getProperty("from");
                emailConfig.user = properties.getProperty("user");
                emailConfig.pwd = properties.getProperty("pwd");
                emailConfig.host = properties.getProperty("host");

                return emailConfig;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public String getFrom() {
        return from;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }

    public String getHost() {
        return host;
    }
}
