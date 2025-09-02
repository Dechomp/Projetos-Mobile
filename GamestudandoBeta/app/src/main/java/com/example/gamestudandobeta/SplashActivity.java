package com.example.gamestudandobeta;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {

    WebView imgGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        imgGif = findViewById(R.id.imgGif);
        imgGif.getSettings().setLoadWithOverviewMode(true);
        imgGif.getSettings().setUseWideViewPort(true);
        imgGif.setInitialScale(1); // Ajusta escala inicial

        imgGif.loadUrl("file:///android_res/drawable/gamestudandologo.gif");

        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {

                exibirMainActivy();

            }
        }, 6300);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void exibirMainActivy(){
        Intent telaInicial;

        telaInicial = new Intent(SplashActivity.this, MainActivity.class);


        startActivity(telaInicial);
        finish();
    }
}