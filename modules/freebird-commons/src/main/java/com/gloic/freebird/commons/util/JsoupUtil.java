package com.gloic.freebird.commons.util;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.URLDecoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Helper that access to a given url with Jsoup
 * @author gloic
 */
@Slf4j
public class JsoupUtil {

    public static Document getDocument(String url) {
        Document doc = null;

        try {
            if (url != null) {
                doc = Jsoup.connect(URLDecoder.decode(url, "UTF-8")).timeout(30000).get();
            } else {
                log.error("Given URL is null");
            }
        } catch (HttpStatusException e) {
//            log.error("HttpStatusException for url: {}", url);
//            log.error("Stacktrace", e);
        } catch (IOException e) {
            log.error("IOException occurred, it's probably a timeout ", e);
        }
        return doc;
    }

    /**
     * Ignore all SSL certificates so the https links can be read.
     */
    private void trustEveryone() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);

            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new X509TrustManager[]{new X509TrustManager() {

                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
        } catch (Exception e) {
            // should never happen
            log.error("Unknown exception occurs when retrieving document", e);
        }
    }
}
