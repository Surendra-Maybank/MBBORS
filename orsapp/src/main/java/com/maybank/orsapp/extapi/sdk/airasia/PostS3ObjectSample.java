package com.maybank.orsapp.extapi.sdk.airasia;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Samples showing how to GET an object from Amazon S3 using Signature V4
 * authorization.
 */
public class PostS3ObjectSample {
    
    /**
     * Request the content of the object '/ExampleObject.txt' from the given
     * bucket in the given region using virtual hosted-style object addressing.
     */
    public static String postS3Object(String bucketName, String regionName, String awsAccessKey, String awsSecretKey,String jsonBody) {
        System.out.println("*******************************************************");
        System.out.println("*  Executing sample 'GetObjectUsingHostedAddressing'  *");
        System.out.println("*******************************************************");
        
        // the region-specific endpoint to the target object expressed in path style
        URL endpointUrl;
        try {
            endpointUrl = new URL("https://" + bucketName + "/v1/external/accrual/creditcard");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Unable to parse service endpoint: " + e.getMessage());
        }
        
        // for a simple GET, we have no body so supply the precomputed 'empty' hash
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
//        headers.put("x-amz-content-sha256", AWS4SignerBase.EMPTY_BODY_SHA256);

        AWS4SignerForAuthorizationHeader signer = new AWS4SignerForAuthorizationHeader(
                endpointUrl, "POST", "execute-api", regionName);
        
        String hashBody = BinaryUtils.toHex(AWS4SignerBase.hash(jsonBody));
        
        String authorization = signer.computeSignature(headers, 
                                                       null, // no query parameters
                                                       hashBody, 
                                                       awsAccessKey, 
                                                       awsSecretKey);
                
        // place the computed signature into a formatted 'Authorization' header
        // and call S3
        headers.put("Authorization", authorization);
//        String response = HttpUtils.invokeHttpRequest(endpointUrl, "POST", headers, jsonBody);
        String response = "";
        try {	
        	return response = MMPAPIUtil.requestOncePost(bucketName, 9993, "/v1/external/accrual/creditcard",headers, jsonBody);
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return response;
    }
}
