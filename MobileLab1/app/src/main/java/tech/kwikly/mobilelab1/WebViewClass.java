package tech.kwikly.mobilelab1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewClass extends Activity {
    private WebView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        String url = "https://google.com/";
        url = getIntent().getStringExtra("URL");
        view = (WebView)findViewById(R.id.webview);
        view.setWebViewClient(new ExtendedBrowser());
        view.getSettings().setLoadsImagesAutomatically(true);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);
    }


    private class ExtendedBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
