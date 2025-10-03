package com.example.verificarseguro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.util.Date;


public class ResultadoActivity extends AppCompatActivity {

    public static String nome;

    public static int quantMesesDemissao, mesesContribuicao, numSolicitacao;

    public static Double salario;

    TextView tvMesesRetirar, tvValorParcela, tvResultado;

    Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);

        tvResultado = findViewById(R.id.tvResultado);
        tvValorParcela = findViewById(R.id.tvValorParcela);
        tvMesesRetirar = findViewById(R.id.tvMesesRetirar);

        btVoltar = findViewById(R.id.btVoltarMain);
        if (numSolicitacao > 0 && numSolicitacao < 4){
            if((numSolicitacao == 1 && quantMesesDemissao <= 12)  ||  (numSolicitacao == 2 && quantMesesDemissao <= 9) ||
                    (numSolicitacao == 3 && quantMesesDemissao <= 6)){
                    double valorParcela;

                    if (salario <= 2138.76){
                        valorParcela = salario * 0.8;
                    }
                    else if (salario <= 3564.96){
                        valorParcela = salario * 0.5 + 1711.01;
                    }
                    else{
                        valorParcela = 2424.11;
                    }

                    if (valorParcela < 1518){
                        valorParcela = 1518;
                    }

                    int quantParcelas;
                    if(mesesContribuicao < 6){
                        quantParcelas = 0;
                    }
                    else if(mesesContribuicao < 12){
                        quantParcelas = 3;
                    }
                    else if(mesesContribuicao < 24){
                        quantParcelas = 4;
                    } else{
                        quantParcelas = 5;
                    }


                DecimalFormat df = new DecimalFormat("####.##");
                tvMesesRetirar.setText(df.format(valorParcela));
                tvValorParcela.setText(String.valueOf(quantParcelas));

                if(quantParcelas == 0){
                    tvResultado.setText("Tempo de contribuição muito baixo");
                }
                else{
                    tvResultado.setText("O Sr(a)" + nome + "receberá R$ " + valorParcela + " por " + quantParcelas + " meses");
                }
            }
            else{
                Toast.makeText(ResultadoActivity.this, "Tempo de solicatacao expirado", Toast.LENGTH_SHORT).show();
                tvResultado.setText("Tempo de solicatacao expirado");
                tvMesesRetirar.setText("0");
                tvValorParcela.setText("0");
            }
        }
        else{
            Toast.makeText(ResultadoActivity.this, "Numero de solicitação inválido", Toast.LENGTH_SHORT).show();
            tvResultado.setText("Numero de solicitação inválido");
            tvMesesRetirar.setText("0");
            tvValorParcela.setText("0");
        }

        btVoltar.setOnClickListener(new View.OnClickListener() {
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