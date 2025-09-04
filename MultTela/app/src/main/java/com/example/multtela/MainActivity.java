package com.example.multtela;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btMedia, btIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btMedia = findViewById(R.id.btMedia);
        btIMC = findViewById(R.id.btIMC);


        btMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String app = "com.dechomp.calculadoraimc";
                Intent media = getPackageManager().getLaunchIntentForPackage(app);

                if(media != null){
                    startActivity(media);
                }
                else{
                    Toast.makeText(MainActivity.this, "App não encontrado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}