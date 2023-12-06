package org.pytorch.demo.objectdetection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PanaromaTrial extends AppCompatActivity {

    String block="",url="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panaroma_trial);
        Intent i= getIntent();
        String blockname = i.getStringExtra("blockname");
        if(blockname!="R&D Block")
        {
            block=blockname.toLowerCase().replaceAll("\\s+","");
           url = "https://elaborate-jelly-61eaf7.netlify.app/"+block;
        }
        else {
            url = "https://elaborate-jelly-61eaf7.netlify.app/rnd";
        }

        CustomTabsIntent intent1 = new CustomTabsIntent.Builder()
                .build();
        intent1.launchUrl(PanaromaTrial.this, Uri.parse(url));


    }
}