package com.vuforia.samples.SampleApplication.utils;

import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by sameer on 12/11/2017.
 */

public class SkyScannerQuery extends AsyncTask<URL,Void,String> {

    @Override
    protected String doInBackground(URL... params) {
        URL searchUrl = params[0];
        String skyScannerSearchResults = null;
        try {
            skyScannerSearchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return skyScannerSearchResults;
    }

}
