package com.pobreng.pedro.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Client {

    private final static Logger logger = Logger.getLogger(Client.class);

    public static HttpResponse get(String url) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            return client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }

        return null;
    }
}
