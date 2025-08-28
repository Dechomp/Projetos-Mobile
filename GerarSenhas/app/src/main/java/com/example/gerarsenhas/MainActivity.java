package com.example.gerarsenhas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btCaixa, btAtendimento, btConta, btAtendimentoP ,btCaixaP, btResetar;

    TextView tvTipo, tvNumero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        btCaixa = findViewById(R.id.btCaixa);
        btAtendimento = findViewById(R.id.btAtendimento);
        btConta = findViewById(R.id.btConta);
        btAtendimentoP = findViewById(R.id.btAtendimentoP);
        btCaixaP = findViewById(R.id.btCaixaP);
        btResetar = findViewById(R.id.btResetar);

        int senhaCaixa = 0, senhaAtendimento = 0, senhaConta = 0, senhaCaixaP = 0, senhaAtendimentoP = 0;
        btCaixa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senhaCaixa++;
                tvTipo.setText("Cx");
                tvNumero.setText(String.valueOf(senhaCaixa).toString());
            }
        });
        btAtendimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senhaAtendimento++;
                tvTipo.setText("At");
                tvNumero.setText(String.valueOf(senhaAtendimento).toString());
            }
        });

        btConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senhaConta++;
                tvTipo.setText("Ct");
                tvNumero.setText(String.valueOf(senhaConta).toString());
            }
        });

        btAtendimentoP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senhaAtendimentoP++;
                tvTipo.setText("AtP");
                tvNumero.setText(String.valueOf(senhaAtendimentoP).toString());
            }
        });

        btCaixaP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senhaCaixaP++;
                tvTipo.setText("CxP");
                tvNumero.setText(String.valueOf(senhaCaixaP).toString());
            }
        });

        btResetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senhaCaixa = 0;
                senhaAtendimento = 0;
                senhaConta = 0;
                senhaAtendimentoP = 0;
                senhaCaixaP = 0;

                tvTipo.setText("---");
                tvNumero.setText("---");
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}