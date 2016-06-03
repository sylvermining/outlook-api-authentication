package com.avantica.auth;

import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.security.KeyStore;
import java.security.KeyStoreException;

/**
 * Created by max.macalupu on 24/05/2016.
 */
public class EWSexample {

    final static String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Ik1uQ19WWmNBVGZNNXBPWWlKSE1iYTlnb0VLWSIsImtpZCI6Ik1uQ19WWmNBVGZNNXBPWWlKSE1iYTlnb0VLWSJ9.eyJhdWQiOiJodHRwczovL291dGxvb2sub2ZmaWNlLmNvbSIsImlzcyI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzVjMTllMGUyLTQwZTktNDc3OC1hNzVmLTE4ODM1MTIzMzcyZS8iLCJpYXQiOjE0NjQ3MjM5NjMsIm5iZiI6MTQ2NDcyMzk2MywiZXhwIjoxNDY0NzI3ODYzLCJhY3IiOiIxIiwiYW1yIjpbInB3ZCJdLCJhcHBpZCI6IjA0YWVmMjU2LTY3YTAtNDI2OC05OTdhLWY4NGE4ODYwYjY5NyIsImFwcGlkYWNyIjoiMSIsImZhbWlseV9uYW1lIjoiTWFuc2lsbGEgTWFsbHF1aSIsImdpdmVuX25hbWUiOiJEaWVnbyIsImlwYWRkciI6IjIwMS4yMzQuNTUuMjIiLCJuYW1lIjoiRGllZ28gTWFuc2lsbGEgTWFsbHF1aSIsIm9pZCI6IjQ2MDFiN2NiLWY1N2QtNDE2ZC04MDM4LTBmNThmYWRkNGQwOCIsIm9ucHJlbV9zaWQiOiJTLTEtNS0yMS0yMTM1NjM3MzQzLTIyOTkxMzI4NjItMjI2MjczMTkyNy03MjEwIiwicHVpZCI6IjEwMDM3RkZFOTZBNEEzMEYiLCJzY3AiOiJNYWlsLlJlYWQgTWFpbC5TZW5kIiwic3ViIjoiRy1fX0YxRlRFUTZCc25TN1F6WFdaQWdlbXdEQmVhWkNMSzNSMHBXWFFUbyIsInRpZCI6IjVjMTllMGUyLTQwZTktNDc3OC1hNzVmLTE4ODM1MTIzMzcyZSIsInVuaXF1ZV9uYW1lIjoiZGllZ28ubWFuc2lsbGFAYXZhbnRpY2EubmV0IiwidXBuIjoiZGllZ28ubWFuc2lsbGFAYXZhbnRpY2EubmV0IiwidmVyIjoiMS4wIn0.dS0Qn5932mMems3yRu9kIRI4CkMP-Tf-n3FXF5mXVFfmXRTPijETSfIucoIfJFdXOukyt8hS9j0mw4NKySd6wNIU8qy7cI__s6ZqR6-_XI8_Dzpj0ct2y--BXBXEN4jPcorSCKguzus8Nu39bQEEg-khLmRe_cI4nqmzYruroluzJQadKktLXftqp1KVyT7zJolMMJQReXWOOalqErI4nS3pCkNIxP-9dMAkprL7KylrBkPlvPY1KwrV7TEX-ak3mp6Rsn3oUVNNmXY5Iq-jhM-6xv6MY4s5qxRZXq89xbgvDf4E5dRDSX0V3rScg4Vw562n8XB4tBH5oNoB3GDb_w";
    final static String KEY = "4RNhHLZU9cJffLFRraPp8fj";

    private static final Base64 base64Url = new Base64(true);
    private JSONObject jsonHeaderObject;
    private JSONObject jsonClaimObject;


    public static void main(String[] args) {
        new EWSexample().validateToken();
    }


    private void validateToken() {
        String[] jwtTokenValues = TOKEN.split("\\.");
        String jwtAssertion = null;
        byte[] jwtSignature = null;

        if (jwtTokenValues.length > 0) {
            String value = new String(base64Url.decode(jwtTokenValues[0].getBytes()));
            System.out.println("JWT Header : " + value);

            JSONParser parser = new JSONParser();
            try {
                jsonHeaderObject = (JSONObject) parser.parse(value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(jwtTokenValues.length > 1){
            String value = new String(base64Url.decode(jwtTokenValues[1].getBytes()));
            System.out.println("JWT Body : " + value);
            jwtAssertion = jwtTokenValues[0] + "." + jwtTokenValues[1];
            JSONParser parser = new JSONParser();
            try {
                jsonClaimObject = (JSONObject) parser.parse(value);
                Gson gsonObject = new Gson();
                BodyToken bodyToken =  gsonObject.fromJson(value,BodyToken.class);
                bodyToken.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(jwtTokenValues.length > 2){
            jwtSignature = base64Url.decode(jwtTokenValues[2].getBytes());
        }

        KeyStore keyStore = null;
        String thumbPrint = new String(base64Url.decode(((String) jsonHeaderObject.get("x5t")).getBytes()));
        String signatureAlgo = (String) jsonHeaderObject.get("alg");

        if("RS256".equals(signatureAlgo)){
            signatureAlgo = "SHA256withRSA";
        } else if("RS515".equals(signatureAlgo)){
            signatureAlgo = "SHA512withRSA";
        } else if("RS384".equals(signatureAlgo)){
            signatureAlgo = "SHA384withRSA";
        } else {
            signatureAlgo = "SHA256withRSA";
        }

        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
//            keyStore.
            e.printStackTrace();
        }
    }
}