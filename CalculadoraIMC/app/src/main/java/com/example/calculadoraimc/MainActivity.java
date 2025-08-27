package com.example.calculadoraimc;

import android.os.Bundle;
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

    EditText edPeso, edAltura;

    TextView tvIMC, tvSituacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btCalcular = findViewById(R.id.btCalcular);
        btLimpar = findViewById(R.id.btLimpar);


        edAltura = findViewById(R.id.edAltura);
        edPeso =  findViewById(R.id.edPeso);

        tvIMC = findViewById(R.id.tvIMC);
        tvSituacao = findViewById(R.id.tvSituacao);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso, altura, IMC;
                try {
                    peso = Double.parseDouble(edPeso.getText().toString());
                    altura = Double.parseDouble(edAltura.getText().toString());

                    IMC = peso / (altura * altura);

                    DecimalFormat df = new DecimalFormat("#.##");

                    tvIMC.setText(df.format(IMC));

                    if (IMC < 18.5){
                        tvSituacao.setText("Abaixo do peso");
                    }
                    else if (IMC < 24.9){
                        tvSituacao.setText("Peso normal");
                    }
                    else if ( IMC < 29.9){
                        tvSituacao.setText("Sobrepeso");
                    }
                    else if (IMC < 34.9){
                        tvSituacao.setText("Obesidade grau I");
                    }
                    else if (IMC < 39.9){
                        tvSituacao.setText("Obesidade grau II");
                    }
                    else{
                        tvSituacao.setText("Obesidade grau III ou mórbida");
                    }
                }
                catch(Exception ex){
                    tvIMC.setText("\nCampos inválidos, digite novamente");
                    tvSituacao.setText("");
                }

            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edAltura.setText("");
                edPeso.setText("");
                tvSituacao.setText("------------");
                tvIMC.setText("------------");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}