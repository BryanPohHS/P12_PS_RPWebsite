package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayWebsite extends AppCompatActivity
{
  WebView webView;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.displaywebpage);

    webView = findViewById(R.id.webViewRP);
    webView.setWebViewClient(new WebViewClient());

    Intent intentRecieved = getIntent();
    String url = intentRecieved.getStringExtra("url");

    webView.loadUrl(url);
  }
}
