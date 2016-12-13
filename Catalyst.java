package alexyou.catalyst;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Catalyst extends AppCompatActivity {
    private WebView webView;
    public static String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        webView = (WebView) findViewById(R.id.webview1);
        webView.setWebViewClient(new MyBrowser());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://utcatalyst.com/");
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //view.loadUrl(url);
            URL = url;
            Intent intent = new Intent(Catalyst.this, Article.class);
            startActivity(intent);
            return true;
        }
    }
    public static String getURL() {
        return URL;
    }
}
