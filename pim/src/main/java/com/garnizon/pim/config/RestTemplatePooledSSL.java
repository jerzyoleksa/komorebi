package com.garnizon.pim.config;

import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Provides the modified spring RestTemplate with 
 * support for SSL, http pooling 
 * and skipping SSL certificate verification
 * 
 * @author jerzy.oleksa@gmail.com
 *
 */
@Configuration
public class RestTemplatePooledSSL {
	
	private static final Logger log = LoggerFactory.getLogger(RestTemplatePooledSSL.class);
	
	@Autowired
	private RestTemplateBuilder builder;
	
    @Bean
    public RestTemplate restTemplate() {
    	
    	RestTemplate restTempl = null;
   	 
		try {

			//skip SSL verification
			TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
			SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
			SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
			
		 	//build pooling connection manager
			HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.getDefaultHostnameVerifier();
			SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
			PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(RegistryBuilder.<ConnectionSocketFactory>create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sslSocketFactory).build());		       
			connMgr.setMaxTotal(200);
			connMgr.setDefaultMaxPerRoute(200);

			//build httpClient
			CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).setConnectionManager(connMgr).build();			    

			//build rest template 
			restTempl = builder.requestFactory(() -> new HttpComponentsClientHttpRequestFactory(httpClient)).build();
			 
		} catch (Exception e) {
			log.error("Error building restTemlate:", e);
		}
   	
        return restTempl;
    }

    
}