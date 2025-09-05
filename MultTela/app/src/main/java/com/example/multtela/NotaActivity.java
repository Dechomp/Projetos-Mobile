package com.example.multtela;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class NotaActivity extends AppCompatActivity {
    Button btCalcular, btLimpar, btVoltarNota;


    EditText edAtv, edP1, edT1, edT2, edMult;

    TextView tvMedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nota);

        btVoltarNota = findViewById(R.id.btVoltarNota);
        btCalcular = findViewById(R.id.btCalcularNota);
        btLimpar = findViewById(R.id.btLimparNota);

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
                    Toast.makeText(NotaActivity.this, "Média: "+ df.format(media), Toast.LENGTH_SHORT).show();

                    if (media >=10){
                        tvMedia.setText("10");
                        tvMedia.setTextColor(Color.parseColor("#008000"));
                    }
                    else if(media >= 9){
                        tvMedia.setTextColor(Color.parseColor("#228B22"));
                    }
                    else if(media >= 8){
                        tvMedia.setTextColor(Color.parseColor("#32CD32"));
                    }
                    else if(media >= 7){
                        tvMedia.setTextColor(Color.parseColor("#7CFC00"));
                    }
                    else if(media >= 6){
                        tvMedia.setTextColor(Color.parseColor("#ADFF2F"));
                    }
                    else if(media >= 5){
                        tvMedia.setTextColor(Color.parseColor("#DAA520"));
                    }
                    else if(media >= 4){
                        tvMedia.setTextColor(Color.parseColor("#FF4500"));
                    }
                    else{
                        tvMedia.setTextColor(Color.parseColor("#FF0000"));
                    }
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
                tvMedia.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });

        edAtv.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus){
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });

        edMult.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus){
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });

        edP1.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus){
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });

        edT1.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus){
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });

        edT2.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus){
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });

        btVoltarNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}