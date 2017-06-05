package com.example.funiculi.trabajo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.amatellanes.android.examples.R;

/**
 * Created by funiculi on 03/06/2017.
 */

public class Main2 extends Activity {


    private WebView webView;
    private ProgressDialog progressDialog;
    private static final String TAG = "Main2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

Log.v(TAG,"llegoooo");
        // Display a indeterminate progress bar on title bar
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        this.setContentView(R.layout.main2);


        this.webView = (WebView) findViewById(R.id.webView2);


        // Register a callback to be invoked when an item in this AdapterView
        // has been clicked


                // Sets the visibility of the indeterminate progress bar in the
                // title
                setProgressBarIndeterminateVisibility(true);
                // Show progress dialog
                progressDialog = ProgressDialog.show(Main2.this,
                        "ProgressDialog", "Loading!");

                // Tells JavaScript to open windows automatically.
                webView.getSettings().setJavaScriptEnabled(true);
                // Sets our custom WebViewClient.
                webView.setWebViewClient(new myWebClient());
                // Loads the given URL
        String recuperamos_variable_integer = getIntent().getStringExtra("variable_integer");
                webView.loadUrl(recuperamos_variable_integer);


    }

    private class myWebClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // Load the given URL on our WebView.
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            // When the page has finished loading, hide progress dialog and
            // progress bar in the title.
            super.onPageFinished(view, url);
            setProgressBarIndeterminateVisibility(false);
            progressDialog.dismiss();
        }
    }
}