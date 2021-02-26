package com.maybank.orsapp.extapi.sdk.malindo;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthPolicy;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.protocol.Protocol;

//
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

public class MalindoUtils{

    public static String sendRequest(String domain, String suffix,String username, String password, String data) {
    	
    	String result = ""; 
    	
    	  Protocol easyhttps = new Protocol("https", new EasySSLProtocolSocketFactory(), 9994);
    	  Protocol.registerProtocol("https", easyhttps);
    	  
    	  HttpClient client = new HttpClient();

          client.getState().setCredentials(
                  new AuthScope("stg.malindo.inspirenetz.com", 9994, "user@inspirenetz.com"),
                  new UsernamePasswordCredentials("stg_maybank_apiuser", "l9cmKpGxOkFh7QV"));

          // Suppose the site supports several authetication schemes: NTLM and Basic
          // Basic authetication is considered inherently insecure. Hence, NTLM authentication
          // is used per default

          // Set the authentication methods to be used in the order
          List authPrefs = new ArrayList(3);
          authPrefs.add(AuthPolicy.BASIC);
          authPrefs.add(AuthPolicy.NTLM);
          authPrefs.add(AuthPolicy.DIGEST);

          // Set the authentication preferences
          client.getParams().setParameter(AuthPolicy.AUTH_SCHEME_PRIORITY, authPrefs);


          String req = "{" + 
          		"    \"agreementCode\": \"02936b30-256a-42ca-848f-e126bddc411f\"," + 
          		"    \"sourceCurrencyCode\": \"MBT\"," + 
          		"    \"destCurrencyCode\": \"MAL\"," + 
          		"    \"qty\": \"105\"," + 
          		"    \"valueType\": \"DEST_CURRENCY_QTY\"," + 
          		"    \"sourceAccountRef\": \"REF00000000120200803101010\"," + 
          		"    \"destAccountRef\": \"9600626406\"," + 
          		"    \"sourceOwnerRef\": \"11\"," + 
          		"    \"destOwnerRef\": \"9\"," + 
          		"    \"externalRef\": \"REF00000000120200803101010\"," + 
          		"    \"debitRef\": \"REF00000000120200803101010\"," + 
          		"    \"preStatus\": \"SOURCE_DEBITED\"," + 
          		"    \"debitTimestamp\": \"2020-12-20T23:36\"," + 
          		"    \"index\": \"1\"" + 
          		"}";

          try {

              // Create a postMethods
              PostMethod httpPost = new PostMethod("https://stg.malindo.inspirenetz.com:9994/inspirenetz-api/api/0.9/json/exchange/request/proceed");

              // Set the SOAPAction to be the action that we need to invoke in the service
              httpPost.setRequestHeader("Content-Type", "application/json");

              // Create the StringRequestEntity using the request xml , contentType and encoding
              StringRequestEntity strEntity = new StringRequestEntity(req, "text/xml","UTF-8");

              // Set the requestEntity for the httpPost method to be strEntity
              httpPost.setRequestEntity(strEntity);

              // Execute the  method
              int status = client.executeMethod(httpPost);

              // Store the response
              result= httpPost.getResponseBodyAsString();

              // Set the response in the txtResponse object

              System.out.println(result);
          }catch(Exception e) {
              e.printStackTrace();
          }
          
          return result;
    }

}
