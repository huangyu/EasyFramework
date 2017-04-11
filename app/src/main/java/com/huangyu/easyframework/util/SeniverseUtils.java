package com.huangyu.easyframework.util;

import android.util.Base64;

import com.huangyu.easyframework.app.AppConstants;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by huangyu on 2017-4-11.
 */
public class SeniverseUtils {

    private SeniverseUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * Generate the URL to get diary weather
     *
     * @param location
     * @param language
     * @param unit
     * @param start
     * @param days
     * @return
     */
    public static String generateGetDiaryWeatherURL(
            String location,
            String language,
            String unit,
            String start,
            String days
    ) throws SignatureException, UnsupportedEncodingException {
        String timestamp = String.valueOf(new Date().getTime());
        String params = "ts=" + timestamp + "&ttl=30&uid=" + AppConstants.SENIVERSE_ID;
        String signedKey = generateSignature(params, AppConstants.SENIVERSE_KEY);
        String signature = URLEncoder.encode(signedKey, "UTF-8");
        return AppConstants.SENIVERSE_WEATHER_DAILY_URL + "?" + params + "&sig=" + signature + "&location=" + location + "&language=" + language + "&unit=" + unit + "&start=" + start + "&days=" + days;
    }

    /**
     * Generate HmacSHA1 signature with given data string and key
     *
     * @param data
     * @param key
     * @return
     * @throws SignatureException
     */
    private static String generateSignature(String data, String key) throws SignatureException {
        String result;
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(data.getBytes("UTF-8"));
//            result = new sun.misc.BASE64Encoder().encode(rawHmac);
            result = Base64.encodeToString(rawHmac, Base64.URL_SAFE);
        } catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }

}
