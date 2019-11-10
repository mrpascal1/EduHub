package com.techelectron.eduhub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CommonWebActivity extends AppCompatActivity {

    WebView webView;
    WebSettings webSettings;

    public static final String nov2018AI = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/CS/SEM5%20CBCS/AI/TYBSC-CS_SEM5_AI_NOV18.pdf";
    public static final String april2019AI = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/CS/SEM5%20CBCS/AI/TYBSC-CS_SEM5_AI_APR19.pdf";

    public static final String nov2018LINUXSERVER = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/CS/SEM5%20CBCS/LSA/TYBSC-CS_SEM5_LSA_NOV18.pdf";
    public static final String april2019LINUXSERVER = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/CS/SEM5%20CBCS/LSA/TYBSC-CS_SEM5_LSA_APR19.pdf";

    public static final String nov2018STQA = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/CS/SEM5%20CBCS/STQA/TYBSC-CS_SEM5_STQA_NOV18.pdf";
    public static final String april2019STQA = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/CS/SEM5%20CBCS/STQA/TYBSC-CS_SEM5_STQA_APR19.pdf";

    public static final String nov2018INS = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/CS/SEM5%20CBCS/INS/TYBSC-CS_SEM5_INS_NOV18.pdf";
    public static final String april2019INS = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/CS/SEM5%20CBCS/INS/TYBSC-CS_SEM5_INS_APR19.pdf";

    public static final String nov2018AIOT = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/CS/SEM5%20CBCS/IOT/TYBSC-CS_SEM5_IOT_NOV18.pdf";

    public static final String nov2018WSERVICES = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/CS/SEM5%20CBCS/WS/TYBSC-CS_SEM5_WS_NOV18.pdf";
    public static final String april2019WSERVICES = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/CS/SEM5%20CBCS/WS/TYBSC-CS_SEM5_WS_APR19.pdf";

    public static final String nov2018GP = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/CS/SEM5%20CBCS/GP/TYBSC-CS_SEM5_GP_NOV18.pdf";
    public static final String april2019GP = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/CS/SEM5%20CBCS/GP/TYBSC-CS_SEM5_GP_APR19.pdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_web);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            /*actionBar.setTitle("University Paper");
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgactionbar));*/
            actionBar.hide();
        }

        webView = findViewById(R.id.commonWebView);
        webView.setWebViewClient(new WebViewClient());
        //webSettings = webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);

        Intent intent = getIntent();
        String message = intent.getStringExtra("YEAR");

        switch (message) {
            case "nov2018AI":
                webView.loadUrl(nov2018AI);
                break;
            case "april2019AI":
                webView.loadUrl(april2019AI);
                break;
            case "nov2018LINUXSERVER":
                webView.loadUrl(nov2018LINUXSERVER);
                break;
            case "april2019LINUXSERVER":
                webView.loadUrl(april2019LINUXSERVER);
                break;
            case "nov2018STQA":
                webView.loadUrl(nov2018STQA);
                break;
            case "april2019STQA":
                webView.loadUrl(april2019STQA);
                break;
            case "nov2018INS":
                webView.loadUrl(nov2018INS);
                break;
            case "april2019INS":
                webView.loadUrl(april2019INS);
                break;
            case "nov2018AIOT":
                webView.loadUrl(nov2018AIOT);
                break;
            case "nov2018WSERVICES":
                webView.loadUrl(nov2018WSERVICES);
                break;
            case "april2019WSERVICES":
                webView.loadUrl(april2019WSERVICES);
                break;
            case "nov2018GP":
                webView.loadUrl(nov2018GP);
                break;
            case "april2019GP":
                webView.loadUrl(april2019GP);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        /*webView.clearHistory();

        // NOTE: clears RAM cache, if you pass true, it will also clear the disk cache.
        // Probably not a great idea to pass true if you have other WebViews still alive.
        webView.clearCache(true);

        // Loading a blank page is optional, but will ensure that the WebView isn't doing anything when you destroy it.

        webView.removeAllViews();
        webView.destroyDrawingCache();

        // NOTE: This pauses JavaScript execution for ALL WebViews,
        // do not use if you have other WebViews still alive.
        // If you create another WebView after calling this,
        // make sure to call mWebView.resumeTimers().
        // NOTE: This can occasionally cause a segfault below API 17 (4.2)
        webView.destroy();*/
    }
}
