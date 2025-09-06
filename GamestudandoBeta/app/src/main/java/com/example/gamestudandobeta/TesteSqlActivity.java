package com.example.gamestudandobeta;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TesteSqlActivity extends AppCompatActivity {
    Button btQuestao1a, btQuestao1b, btQuestao1c, btQuestao1d;
    Button btQuestao2a, btQuestao2b, btQuestao2c, btQuestao2d;

    TextView tvQuestao1, tvQuestao2;

    String respCerta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teste_sql);

        btQuestao1a = findViewById(R.id.btTesteSql1A);
        btQuestao1b = findViewById(R.id.btTesteSql1B);
        btQuestao1c = findViewById(R.id.btTesteSql1C);
        btQuestao1d = findViewById(R.id.btTesteSql1D);

        btQuestao2a = findViewById(R.id.btTesteSql2A);
        btQuestao2b = findViewById(R.id.btTesteSql2B);
        btQuestao2c = findViewById(R.id.btTesteSql2C);
        btQuestao2d = findViewById(R.id.btTesteSql2D);

        tvQuestao1 = findViewById(R.id.tvQuestao1);
        tvQuestao2 = findViewById(R.id.tvQuestao2);



        carregarPerguntas();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void carregarPerguntas(){
        ArrayList<String> linhas = new ArrayList<>();
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.perguntas);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String linha;

            while((linha = bufferedReader.readLine()) != null){
                linhas.add(linha);
            }

            bufferedReader.close();
            inputStream.close();

        } catch (Exception e) {
            Toast.makeText(TesteSqlActivity.this, "Erro", Toast.LENGTH_SHORT).show();
        }

        if (!linhas.isEmpty()){
            /*String[] perguntas = new String[10];
            Random random = new Random();

            Set ordem = new TreeSet();
            for (int i = 0; i < 3; i++){
                ordem.add(random.nextInt(3));
            }

            for(int i = 0; i < 3; i++){
                perguntas[i] = linhas.get((Integer) ordem.toArray()[i]);
                exibirPergunta(perguntas[i]);
            }*/

            String pergunta = linhas.get(0);
            exibirPergunta(pergunta);

        }

    }
    private void exibirPergunta(String linha){
        String[] partes = linha.split(";");

        if(partes.length >= 6){

            String pergunta = partes[0];
            String respA = partes[1];
            String respB = partes[2];
            String respC = partes[3];
            String respD = partes[4];
            respCerta = partes[5];

            tvQuestao1.setText(tvQuestao1.getText() + pergunta);

            btQuestao1a.setText("a) " + respA);
            btQuestao1b.setText("b) " + respB);
            btQuestao1c.setText("c) " + respC);
            btQuestao1d.setText("d) " + respD);

            btQuestao1a.setOnClickListener(v -> verificarResp(btQuestao1a.getText().toString(), btQuestao1a.getId()));
            //btQuestao1b.setOnClickListener(v -> verificarResp(btQuestao1b.getText().toString()));
            //btQuestao1c.setOnClickListener(v -> verificarResp(btQuestao1c.getText().toString()));
            //btQuestao1d.setOnClickListener(v -> verificarResp(btQuestao1d.getText().toString()));
        }
    }

    private void verificarResp(String repostaEsc, int btEsc){
        if (repostaEsc.equals(respCerta)){
            Toast.makeText(TesteSqlActivity.this, "Acertou!", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(TesteSqlActivity.this, "Errou!", Toast.LENGTH_SHORT).show();
        }
    }

}