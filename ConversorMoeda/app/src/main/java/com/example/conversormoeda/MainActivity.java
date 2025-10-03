package com.example.conversormoeda;

import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btConverter;

    EditText edMoeda1, edMoeda2;

    TextView tvValorConvertido;

    EditText edDolar, edEuro, edQuantidadeMoedas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btConverter = findViewById(R.id.btConverter);
        edMoeda1 = findViewById(R.id.edMoeda1);
        edMoeda2 = findViewById(R.id.edMoeda2);
        tvValorConvertido = findViewById(R.id.tvValorConvertido);

        btConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double moeda1, moeda2, valorConvertido;


                if (edMoeda1.getText().toString().equals("") || edMoeda1.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Valores Vazios, corrija!!!!", Toast.LENGTH_SHORT).show();
                    tvValorConvertido.setText("Valores Vazios, corrija!!!!");
                }
                else{
                    try {
                        moeda1 = Double.parseDouble(edMoeda1.getText().toString());
                        moeda2 = Double.parseDouble(edMoeda2.getText().toString());
                        valorConvertido = moeda1 * moeda2;
                        DecimalFormat df = new DecimalFormat("#.##");
                        Toast.makeText(MainActivity.this,"Conversão: " + df.format(valorConvertido), Toast.LENGTH_SHORT).show();
                        tvValorConvertido.setText("Conversão: " + df.format(valorConvertido));
                    }
                    catch (Exception ex){
                        Toast.makeText(MainActivity.this,"Campos Incorretos, corrija!!!!", Toast.LENGTH_SHORT).show();
                        tvValorConvertido.setText("Campos Incorretos, corrija!!!!");
                    }
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