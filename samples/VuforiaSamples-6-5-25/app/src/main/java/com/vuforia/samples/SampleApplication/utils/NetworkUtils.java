package com.vuforia.samples.SampleApplication.utils;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by sameer on 12/11/2017.
 */

public class NetworkUtils {


    final static String SKYSCANNER_BASE_URL = "http://partners.api.skyscanner.net/apiservices/browsequotes/v1.0";
    final static String APIKEY = "ha855394561319855961457712201671";

    public static URL buildUrl(String skyScannerSearchQuery) {
        //"/browsequotes/v1.0/{country}/{currency}/{locale}/{originPlace}/{destinationPlace}/{outboundPartialDate}/{inboundPartialDate}"
        Uri builtUri = Uri.parse(SKYSCANNER_BASE_URL).buildUpon()
                .appendPath(skyScannerSearchQuery)
                .appendQueryParameter("apikey", APIKEY)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
