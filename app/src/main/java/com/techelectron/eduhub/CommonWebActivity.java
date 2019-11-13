package com.techelectron.eduhub;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class CommonWebActivity extends AppCompatActivity {

    WebView webView;

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


    //TODO:IT SEM 5
    public static final String nov2018SPM = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/IT/SEM5%20CBCS/SPM/TYBSC-IT_SEM5_SPM_NOV18.pdf";
    public static final String april2019SPM = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/IT/SEM5%20CBCS/SPM/TYBSC-IT_SEM5_SPM_APR19.pdf";

    public static final String nov2018IOT = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/IT/SEM5%20CBCS/IOT/TYBSC-IT_SEM5_IOT_NOV18.pdf";
    public static final String april2019IOT = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/IT/SEM5%20CBCS/IOT/TYBSC-IT_SEM5_IOT_APR19.pdf";

    public static final String nov2018ITAI = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/IT/SEM5%20CBCS/AI/TYBSC-IT_SEM5_AI_NOV18.pdf";
    public static final String april2019ITAI = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/IT/SEM5%20CBCS/AI/TYBSC-IT_SEM5_AI_APR19.pdf";

    public static final String nov2018AWP = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/IT/SEM5%20CBCS/AWP/TYBSC-IT_SEM5_AWP_NOV18.pdf";
    public static final String april2019AWP = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/IT/SEM5%20CBCS/AWP/TYBSC-IT_SEM5_AWP_APR19.pdf";

    public static final String nov2018ITLSA = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/IT/SEM5%20CBCS/LSA/TYBSC-IT_SEM5_LSA_NOV18.pdf";
    public static final String april2019ITLSA = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/IT/SEM5%20CBCS/LSA/TYBSC-IT_SEM5_LSA_APR19.pdf";

    public static final String nov2018EJ = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/IT/SEM5%20CBCS/EJ/TYBSC-IT_SEM5_EJ_NOV18.pdf";
    public static final String april2019EJ = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/IT/SEM5%20CBCS/EJ/TYBSC-IT_SEM5_EJ_APR19.pdf";

    public static final String nov2018NGT = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/IT/SEM5%20CBCS/NGT/TYBSC-IT_SEM5_NGT_NOV18.pdf";
    public static final String april2019NGT = "http://docs.google.com/gview?embedded=true&url=" +
            "https://muquestionpapers.com/download/BSC/IT/SEM5%20CBCS/NGT/TYBSC-IT_SEM5_NGT_APR19.pdf";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_web);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }

        final ProgressDialog dialog = new ProgressDialog(CommonWebActivity.this);
        dialog.setMessage("Loading...");
        dialog.show();

        webView = findViewById(R.id.commonWebView);
        //webView.setWebViewClient(new WebViewClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        dialog.setMessage("Loading...");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

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

//TODO:IT STARTS HERE
            case "nov2018SPM":
                webView.loadUrl(nov2018SPM);
                break;
            case "april2019SPM":
                webView.loadUrl(april2019SPM);
                break;


            case "nov2018IOT":
                webView.loadUrl(nov2018IOT);
                break;
            case "april2019IOT":
                webView.loadUrl(april2019IOT);
                break;


            case "nov2018ITAI":
                webView.loadUrl(nov2018ITAI);
                break;
            case "april2019ITAI":
                webView.loadUrl(april2019ITAI);
                break;


            case "nov2018AWP":
                webView.loadUrl(nov2018AWP);
                break;
            case "april2019AWP":
                webView.loadUrl(april2019AWP);
                break;


            case "nov2018ITLSA":
                webView.loadUrl(nov2018ITLSA);
                break;
            case "april2019ITLSA":
                webView.loadUrl(april2019ITLSA);
                break;


            case "nov2018EJ":
                webView.loadUrl(nov2018EJ);
                break;
            case "april2019EJ":
                webView.loadUrl(april2019EJ);
                break;

            case "nov2018NGT":
                webView.loadUrl(nov2018NGT);
                break;
            case "april2019NGT":
                webView.loadUrl(april2019NGT);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        /*webView.clearHistory();
        webView.clearCache(true);
        webView.removeAllViews();
        webView.destroyDrawingCache();
        webView.destroy();*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
