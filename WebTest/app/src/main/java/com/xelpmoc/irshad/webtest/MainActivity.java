package com.xelpmoc.irshad.webtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.xelpmoc.irshad.webtest.apiservice.HttpRef;
import com.xelpmoc.irshad.webtest.model.UriModel;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getUriPath();


    }
    public void getUriPath(){
        retrofit2.Call<UriModel> call=HttpRef.createService().getUriPath();
        call.enqueue(new Callback<UriModel>() {
            @Override
            public void onResponse(retrofit2.Call<UriModel> call, Response<UriModel> response) {
                if(response.body().getUrl()!=null){
                    loadUrl(response.body().getUrl());
                }
                else {
                    Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(retrofit2.Call<UriModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void loadUrl(String urlpath){
        Intent intent = getIntent();
        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(urlpath);





    }
}
