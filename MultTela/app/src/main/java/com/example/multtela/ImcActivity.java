package com.example.multtela;

import static android.widget.Toast.LENGTH_SHORT;

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

public class ImcActivity extends AppCompatActivity {

    Button btCalcular, btLimpar, btVoltarIMC;

    EditText edPeso, edAltura;

    TextView tvIMC, tvSituacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imc);

        btCalcular = findViewById(R.id.btCalcularIMC);
        btLimpar = findViewById(R.id.btLimparIMC);
        btVoltarIMC = findViewById(R.id.btVoltarIMC);

        edAltura = findViewById(R.id.edAltura);
        edPeso = findViewById(R.id.edPeso);

        tvIMC = findViewById(R.id.tvIMC);
        tvSituacao = findViewById(R.id.tvSituacao);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso, altura, IMC = 0;
                try {
                    peso = Double.parseDouble(edPeso.getText().toString());
                    altura = Double.parseDouble(edAltura.getText().toString());

                    if(altura > 0 && peso >= 1){
                        IMC = peso / (altura * altura);

                        DecimalFormat df = new DecimalFormat("#.##");

                        tvIMC.setText(df.format(IMC));

                        Toast.makeText(ImcActivity.this, "IMC: " + df.format(IMC), Toast.LENGTH_SHORT).show();
                        if (IMC < 18.5){
                            tvSituacao.setText("Abaixo do peso");
                            tvSituacao.setTextColor(Color.parseColor("#ADFF2F"));
                        }
                        else if (IMC < 24.9){
                            tvSituacao.setText("Peso normal");
                            tvSituacao.setTextColor(Color.parseColor("#00FF00"));
                        }
                        else if ( IMC < 29.9){
                            tvSituacao.setText("Sobrepeso");
                            tvSituacao.setTextColor(Color.parseColor("#00FF00"));
                        }
                        else if (IMC < 34.9){
                            tvSituacao.setText("Obesidade grau I");
                            tvSituacao.setTextColor(Color.parseColor("#FFA500"));
                        }
                        else if (IMC < 39.9){
                            tvSituacao.setText("Obesidade grau II");
                            tvSituacao.setTextColor(Color.parseColor("#FF4500"));

                        }
                        else{
                            tvSituacao.setText("\nObesidade grau III ou mórbida");
                            tvSituacao.setTextColor(Color.parseColor("#FF0000"));
                        }
                    }
                    else{
                        tvIMC.setText("\nAltura ou peso Impossivel");
                        tvSituacao.setText("");
                        tvSituacao.setTextColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(ImcActivity.this, "Altura Impossivel ou peso Impossivel", LENGTH_SHORT).show();
                    }



                }
                catch(Exception ex){
                    tvIMC.setText("\nCampos inválidos, digite novamente");
                    tvSituacao.setText("");
                    tvSituacao.setTextColor(Color.parseColor("#FFFFFF"));
                    Toast.makeText(ImcActivity.this, "Campos inválidos, digite novamente", LENGTH_SHORT).show();
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
                tvSituacao.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });

        edPeso.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus){
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });
        edAltura.setOnFocusChangeListener(((v, hasFocus) -> {
            if(!hasFocus){
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        }));


        btVoltarIMC.setOnClickListener(new View.OnClickListener() {
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