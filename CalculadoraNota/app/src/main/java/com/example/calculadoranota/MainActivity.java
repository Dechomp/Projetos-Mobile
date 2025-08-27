package com.example.calculadoranota;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btCalcular, btLimpar;


    EditText edAtv, edP1, edT1, edT2, edMult;

    TextView tvMedia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btCalcular = findViewById(R.id.btCalcular);
        btLimpar = findViewById(R.id.btLimpar);

        edAtv = findViewById(R.id.edAtv);
        edP1 = findViewById(R.id.edP1);
        edT1 = findViewById(R.id.edT1);
        edT2 = findViewById(R.id.edT2);
        edMult = findViewById(R.id.edMult);

        tvMedia = findViewById(R.id.tvMedia);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double atv, p1, t1, t2, mult, media;
                try {
                    atv = Double.parseDouble(edAtv.getText().toString());
                    p1 = Double.parseDouble(edP1.getText().toString());
                    t1 = Double.parseDouble(edT1.getText().toString());
                    t2 = Double.parseDouble(edT2.getText().toString());
                    mult = Double.parseDouble(edMult.getText().toString());

                    media = atv * 0.2 + p1 * 0.2 + t1 * 0.3 + t2 * 0.3 + mult * 0.1;
                    DecimalFormat df = new DecimalFormat("#.##");
                    tvMedia.setText(df.format(media));
                }
                catch (Exception ex){
                    tvMedia.setText("\nCampos vazios, corrija por favor!");
                }


            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edAtv.setText("");
                edP1.setText("");
                edT1.setText("");
                edT2.setText("");
                edMult.setText("");
                tvMedia.setText("------------");
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}