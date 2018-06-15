package com.pobreng.pedro.util;


import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
    private static Config config = new Config();
    private final static Logger logger = Logger.getLogger(Util.class);

    public static Config getConfig() {
        Properties prop = new Properties();
        InputStream input;
        try {
            input = new FileInputStream("config.properties");
            prop.load(input);

            config.setAppURL((String) prop.get("APP_URL"));

            return config;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }


        return null;
    }
}
