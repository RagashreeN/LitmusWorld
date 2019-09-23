package com.litmus.interview.feature.webview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.litmus.interview.R;

public class WebviewActivity extends AppCompatActivity {
    WebView webView;
    FrameLayout frameLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        initialize();
    }

    private void initialize(){
        frameLayout = (FrameLayout) findViewById(R.id.progressWebview);
        String name = getIntent().getStringExtra("searchName");
        String url = "https://en.wikipedia.org/wiki/"+name;
        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.setWebViewClient(new MyBrowser());
        webView.loadUrl(url);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            frameLayout.setVisibility(View.GONE);
            super.onPageFinished(view, url);
        }
    }

}
