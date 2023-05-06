package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class contenido extends AppCompatActivity {

    private WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);

        wv = (WebView) findViewById(R.id.WebView);
        wv.setWebViewClient(new WebViewClient());
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setLoadWithOverviewMode(true);  // ajustar el contenido al ancho de la vista
      wv.getSettings().setUseWideViewPort(true);
        wv.loadUrl("file:///android_asset/datos.html");

        Button button2 = (Button) findViewById(R.id.button2);
       TextView textView6= (TextView) findViewById(R.id.textView6);
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);

        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                textView6.setText("No se pudo cargar la página. Verifica tu conexión a internet y vuelve a intentarlo.");
                textView6.setVisibility(View.VISIBLE);
                wv.setVisibility(View.GONE);
            }
        });


    button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView6.setVisibility(View.GONE);
                wv.setVisibility(View.VISIBLE);
                wv.setWebViewClient(new WebViewClient());
                wv.getSettings().setJavaScriptEnabled(true);
                wv.getSettings().setLoadWithOverviewMode(true);  // ajustar el contenido al ancho de la vista
                wv.getSettings().setUseWideViewPort(true);
                String url = "https://es.surveymonkey.com/r/FS6JY6F";
                wv.loadUrl(url);
            }
        });


        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                wv.setVisibility(View.VISIBLE);
            }

        });
    }

    @Override
    public void onBackPressed() {
        if (wv.canGoBack()) {

            wv.goBack();
        } else {

            super.onBackPressed();
        }
    }
}