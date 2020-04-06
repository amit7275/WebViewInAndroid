package com.javaoneworld.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private Intent intent;
    private WebSettings webSettings;

    private String strUrl;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading...");

        intent = getIntent();

        if(intent != null && intent.getStringExtra("URL") != null && !intent.getStringExtra("URL").isEmpty())
            strUrl = intent.getStringExtra("URL");

        webView = findViewById(R.id.webView);

        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);




        if(strUrl != null){
            progressDialog.show();
            webView.loadUrl(strUrl);
        }else
        {
            Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show();
        }


        //the first url which you are opening will open in this webView but after that if you click on any url the next
        //url will open in default browser of your device
        //to avoid this issue we can use our custom web_client and override shouldOverrideUrlLoading()

            webView.setWebViewClient(new MyWebViewClient());
    }

    public class MyWebViewClient extends WebViewClient{


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);

            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            //Write something here
            //after successful loading of url

            if(progressDialog != null)
                progressDialog.dismiss();
        }
    }
}
