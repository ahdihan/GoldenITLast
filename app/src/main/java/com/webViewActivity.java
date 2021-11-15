package com;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bitleet.goldenwayit.R;

public class webViewActivity extends AppCompatActivity {

    private WebView myWeb;
    ProgressBar progressBar;
    SwipeRefreshLayout swipeRefreshLayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        getWindow().setStatusBarColor(ContextCompat.getColor(webViewActivity.this, R.color.black));

        //progressbar and swipe refresh

        progressBar = findViewById(R.id.progress);
        swipeRefreshLayout = findViewById(R.id.swipe);

        //WebView
        myWeb = findViewById(R.id.webViewId);
        Intent intent = getIntent();
        String weblink = intent.getStringExtra("links");

        WebSettings webSettings = myWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //improve webview performance
        myWeb.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        myWeb.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        myWeb.getSettings().setAppCacheEnabled(true);
        myWeb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);




        //Force links open in webview only
        myWeb.setWebViewClient(new myWebViewClient());
        myWeb.loadUrl(weblink); // under improve

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        myWeb.loadUrl(weblink);
                    }
                },10);
            }
        });


        swipeRefreshLayout.setColorSchemeColors(

                getResources().getColor(android.R.color.holo_blue_bright),
                getResources().getColor(android.R.color.holo_orange_dark),
                getResources().getColor(android.R.color.holo_green_dark),
                getResources().getColor(android.R.color.holo_red_dark)
        );
    }

    public class myWebViewClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url); //weblink set kor
            return true;
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
           // myWeb.loadUrl("file:///android_asset/lost.html");
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    public void onBackPressed() {

        if (myWeb.canGoBack()) {
            myWeb.goBack();
            Toast.makeText(this, "Going back to previous", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "Going Back to Previous Page", Toast.LENGTH_SHORT).show();
            super.onBackPressed();

        }
    }
}