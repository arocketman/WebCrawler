
package com.redditprog.webcrawler;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Rok
 * @author ryan
 */
public class SubRedditChecker {

    public static boolean verifySubReddit(String sub) {

        try {
            // set the full url of the user input subreddit
            final URL url = new URL("http://reddit.com/r/" + sub);

            // create a new connection
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();

            // connects to the http
            huc.connect();

            // Extract the redirect url in string
            InputStream is = null;
            String redirectURL = "";
            try {
                is = huc.getInputStream();
                redirectURL = huc.getURL().getPath();
                is.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
            // checks if it is a redirect and return boolean value
            return redirectURL.contains("/r/");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
