package com.example.verificarseguro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    Button btVerificar;

    EditText edNome, edMesesDemissao, edSalario, edMesesContibuicao, edNumSolicitacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btVerificar = findViewById(R.id.btVerificar);

        edMesesDemissao = findViewById(R.id.edMesesDemissao);
        edNome =  findViewById(R.id.edNome);
        edSalario = findViewById(R.id.edSalario);
        edMesesContibuicao = findViewById(R.id.edMesesContibuicao);
        edNumSolicitacao = findViewById(R.id.edNumSolicitacao);

        btVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edMesesDemissao.getText().isEmpty() || edNome.getText().isEmpty() || edSalario.getText().isEmpty() ||
                        edMesesContibuicao.getText().isEmpty() || edNumSolicitacao.getText().isEmpty()){
                    Toast.makeText(MainActivity.this, "Campo(s) Vazio(s)", Toast.LENGTH_SHORT).show();
                }
                else{
                    ResultadoActivity.salario = Double.parseDouble(edSalario.getText().toString());
                    ResultadoActivity.nome = edNome.getText().toString();
                    ResultadoActivity.quantMesesDemissao = Integer.parseInt(edMesesDemissao.getText().toString());
                    ResultadoActivity.mesesContribuicao = Integer.parseInt(edMesesContibuicao.getText().toString());
                    ResultadoActivity.numSolicitacao = Integer.parseInt(edNumSolicitacao.getText().toString());
                    Intent telaResultado = new Intent(MainActivity.this, ResultadoActivity.class);

                    startActivity(telaResultado);

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