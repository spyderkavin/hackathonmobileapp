package com.spyderkavin.mycommobileapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
//Androidx Imports
import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //WebView Code
    private WebView mywebView;

    //Post Notifications Code
    private final ActivityResultLauncher<String> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
        @Override
        public void onActivityResult(Boolean o) {
            if (o) {
                Toast.makeText(MainActivity.this, "Post notification permission granted!", Toast.LENGTH_SHORT).show();
            }
        }
    });
    private static final int REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //findViewbyID
        //mywebView = findViewById(R.id.webview);
        setContentView(R.layout.activity_main);

        ///Request Notification Permissions
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                activityResultLauncher.launch(Manifest.permission.POST_NOTIFICATIONS);
            }
        }

/*
        //Website Code Optimization
        //Webview Code
        mywebView.setWebViewClient(new WebViewClient());
        WebSettings webSetting = mywebView.getSettings();
        webSetting.setBuiltInZoomControls(true);
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("nba.com");
        WebSettings webSettings = mywebView.getSettings();
        //webSettings.setJavaScriptEnabled(true);
*/
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://87c9-206-213-190-64.ngrok-free.app/ ");

    };
}