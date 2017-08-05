package com.xrdcode.pertemuan1.utilities;

import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by reysd on 05/08/2017.
 */

public class NetworkUtils {

    final static String GITHUB_BASE_URL = "https://api.github.com/search/repositories";
    final static String PARAM_QUERY = "q";

    final static String PARAM_SORT = "sort";
    final static String sortBy = "stars";

    public NetworkUtils() {

    }

    public static URL buildUrl(String githubQuery) {
        Uri builtUri = Uri.parse(githubQuery).buildUpon()
                .appendQueryParameter(PARAM_QUERY, githubQuery)
                .appendQueryParameter(PARAM_SORT, sortBy).build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }


}
