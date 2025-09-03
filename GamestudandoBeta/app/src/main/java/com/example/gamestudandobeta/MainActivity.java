package com.example.gamestudandobeta;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btSQL, btJava, btAndroid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {


            btSQL = findViewById(R.id.btSQL);
            btJava = findViewById(R.id.btJava);
            btAndroid = findViewById(R.id.btAndroid);

            btSQL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent testeSQL;

                    testeSQL = new Intent(MainActivity.this, TesteSqlActivity.class);

                    startActivity(testeSQL);
                }
            });

            btJava.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent testeJava;

                    testeJava = new Intent(MainActivity.this, TesteJavaActivity.class);

                    startActivity(testeJava);
                }
            });

            btAndroid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent testeAndroid;

                    testeAndroid = new Intent(MainActivity.this, TesteAndroidActivity.class);


                    startActivity(testeAndroid);
                }
            });
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }


}