package com.example.verificarcpf;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btVerificar, btLimpar;


    TextView tvRegiao, tvValida;

    EditText edCPF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btLimpar = findViewById(R.id.btLimpar);
        btVerificar = findViewById(R.id.btVerificar);

        edCPF = findViewById(R.id.edCPF);

        tvRegiao = findViewById(R.id.tvRegiao);
        tvValida = findViewById(R.id.tvValida);


        btVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cpf;

                cpf = edCPF.getText().toString();

                int tam = cpf.length();

                if (tam != 11){
                    tvRegiao.setText("CPF inválido");
                    tvValida.setText("CPF inválido");
                }
                else{
                    int[] digitos = new int[11];

                    for (int i = 0; i < tam ; i++){
                        digitos[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
                    }

                    switch (digitos[8]){
                        case 0:
                            tvRegiao.setText(" 0 |  Rio Grande do Sul");
                            break;

                        case 1:
                            tvRegiao.setText(" 1 | Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul e Tocantins");
                            break;

                        case 2:
                            tvRegiao.setText(" 2 |  Amazonas, Pará, Roraima, Amapá, Acre e Rondônia");
                            break;

                        case 3:
                            tvRegiao.setText(" 3 |  Ceará, Maranhão e Piauí");
                            break;

                        case 4:
                            tvRegiao.setText(" 4 |  Paraíba, Pernambuco, Alagoas e Rio Grande do Norte");
                            break;

                        case 5:
                            tvRegiao.setText(" 5 |  Bahia e Sergipe");
                            break;

                        case 6:
                            tvRegiao.setText(" 6 |  Minas Gerais");
                            break;

                        case 7:
                            tvRegiao.setText(" 7 |  Rio de Janeiro e Espírito Santo");
                            break;

                        case 8:
                            tvRegiao.setText(" 8 |  São Paulo");
                            break;

                        case 9:
                            tvRegiao.setText(" 9 |  Paraná e Santa Catarina");
                            break;
                        default:
                            tvRegiao.setText("CPF inválido");
                            tvValida.setText("CPF inválido");

                    }

                    int j = 10, soma = 0;
                    for (int i = 0; i < tam - 2; i++, j--){
                        soma += digitos[i] * j;
                    }

                    int resto = soma % 11;

                    int controle1 = 11 - resto;

                    if (controle1 > 9){
                        controle1 = 0;
                    }

                    j = 11;
                    soma = 0;

                    for (int i = 0; i < tam - 1; i++, j--){
                        soma += digitos[i] * j;
                    }

                    resto = soma % 11;

                    int controle2 = 11 - resto;

                    if(controle2 > 9){
                        controle2 = 0;
                    }

                    if (digitos[9] == controle1 && digitos[10] == controle2){
                        tvValida.setText("CPF válido");
                    }
                    else{
                        tvValida.setText("CPF inválido");
                    }

                }

            }
        });


        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvRegiao.setText("----------");
                tvValida.setText("----------");
                edCPF.setText("");
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}