package com.maybank.orsapp.extapi.sdk.airasia;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

public class MMPAPIUtil {
	
	public static String requestOncePost(final String domain, int port, String urlSuffix, Map<String, String> mapHeaders,
			String data) throws Exception {
		
		BasicHttpClientConnectionManager connManager;
	      
	        	
	        	HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
	            SSLContext sslContext = SSLContext.getInstance("TLS");
	            sslContext.init(null, new TrustManager[]{ new AlwaysTrustManager() }, null);
	            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(
	                    sslContext,
	                    null,
	                    null,
	                    hostnameVerifier);
	            
	            
	            connManager = new BasicHttpClientConnectionManager(
	                    RegistryBuilder.<ConnectionSocketFactory>create()
	                            .register("http", PlainConnectionSocketFactory.getSocketFactory())
	                            .register("https", sslConnectionSocketFactory)
	                            .build(),
	                    null,
	                    null,
	                    null
	            );

	        HttpClient httpClient = HttpClientBuilder.create()
	                .setConnectionManager(connManager)
	                .build();

	       
	        String url = "https://".concat(domain).concat(":").concat(Integer.toString(port)).concat(urlSuffix);

	        HttpPost httpPost = new HttpPost(url);
	        
	        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000)
	        		.setConnectTimeout(10000).build();
	        
	        httpPost.setConfig(requestConfig);

	        StringEntity postEntity = new StringEntity(data, "UTF-8");
	
	        for ( String headerKey : mapHeaders.keySet() ) {
                httpPost.addHeader(headerKey, mapHeaders.get(headerKey));
            }
	               
	        httpPost.setEntity(postEntity);

	        HttpResponse httpResponse = httpClient.execute(httpPost);
	        HttpEntity httpEntity = httpResponse.getEntity();
	        return EntityUtils.toString(httpEntity, "UTF-8");
    }
	
	public static String requestOnceGet(final String domain, int port, String urlSuffix, Map<String, String> mapHeaders,
			String memberId) throws Exception {
		
		BasicHttpClientConnectionManager connManager;
	      
	        	
	        	HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
	            SSLContext sslContext = SSLContext.getInstance("TLS");
	            sslContext.init(null, new TrustManager[]{ new AlwaysTrustManager() }, null);
	            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(
	                    sslContext,
	                    null,
	                    null,
	                    hostnameVerifier);
	            
	            
	            connManager = new BasicHttpClientConnectionManager(
	                    RegistryBuilder.<ConnectionSocketFactory>create()
	                            .register("http", PlainConnectionSocketFactory.getSocketFactory())
	                            .register("https", sslConnectionSocketFactory)
	                            .build(),
	                    null,
	                    null,
	                    null
	            );

	        HttpClient httpClient = HttpClientBuilder.create()
	                .setConnectionManager(connManager)
	                .build();

	            
	        String url = "https://".concat(domain).concat(":").concat(Integer.toString(port)).concat(urlSuffix).concat(memberId);

	        HttpGet httpGet = new HttpGet(url);
	        
	        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000)
	        		.setConnectTimeout(10000).build();
	        
	        httpGet.setConfig(requestConfig);
	
	        for ( String headerKey : mapHeaders.keySet() ) {
	        	httpGet.addHeader(headerKey, mapHeaders.get(headerKey));
            }

	        HttpResponse httpResponse = httpClient.execute(httpGet);
	        HttpEntity httpEntity = httpResponse.getEntity();
	        return EntityUtils.toString(httpEntity, "UTF-8");
    }
	 private static class AlwaysTrustManager implements X509TrustManager {
	        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
	        }

	        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
	        }

	        public X509Certificate[] getAcceptedIssuers() {
	            return null;
	        }
	 }
}
