package com.tiny.browser;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends android.app.Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        LinearLayout l = new LinearLayout(this);
        l.setOrientation(1);
        EditText u = new EditText(this);
        WebView w = new WebView(this);
        w.getSettings().setJavaScriptEnabled(true);
        w.setWebViewClient(new WebViewClient());
        l.addView(u);
        l.addView(w, new LinearLayout.LayoutParams(-1, -1, 1));
        setContentView(l);
        u.setOnEditorActionListener((v, a, e) -> {
            String s = u.getText().toString();
            w.loadUrl(s.contains(".") && !s.contains(" ") ? (s.startsWith("http") ? s : "https://" + s) : "https://google.com/search?q=" + s);
            return false;
        });
    }
}
