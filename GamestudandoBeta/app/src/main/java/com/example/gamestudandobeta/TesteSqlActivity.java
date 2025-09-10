package com.example.gamestudandobeta;

import static android.graphics.Color.*;

import android.content.Intent;
import android.graphics.Color;
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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TesteSqlActivity extends AppCompatActivity {
    Button btQuestao1a, btQuestao1b, btQuestao1c, btQuestao1d, btVerificar, btSelecionado;

    TextView tvQuestaoNum, tvQuestaoTexto;

    String respCerta;

    int numQuestao = 0;

    ArrayList<String> linhas = new ArrayList<>();

    int[] ordem = new int[30];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teste_sql);

        btQuestao1a = findViewById(R.id.btTesteSql1A);
        btQuestao1b = findViewById(R.id.btTesteSql1B);
        btQuestao1c = findViewById(R.id.btTesteSql1C);
        btQuestao1d = findViewById(R.id.btTesteSql1D);



        tvQuestaoNum = findViewById(R.id.tvQuestaoSQLNum);
        tvQuestaoTexto = findViewById(R.id.tvQuestaoSQLTexto);

        btVerificar = findViewById(R.id.btVerificarSQL);


        carregarPerguntas();

        Global.acertosSql = 0;
        Global.errosSql = 0;

        btQuestao1a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btSelecionado != btQuestao1a){
                    btSelecionado = btQuestao1a;

                    btQuestao1a.setBackgroundColor(parseColor("#66e0ff"));
                    btQuestao1b.setBackgroundColor(parseColor("#668cff"));
                    btQuestao1c.setBackgroundColor(parseColor("#668cff"));
                    btQuestao1d.setBackgroundColor(parseColor("#668cff"));

                    btVerificar.setClickable(true);
                    btVerificar.setBackgroundColor(parseColor("#bfff00"));

                }
                else{
                    btQuestao1a.setBackgroundColor(parseColor("#668cff"));
                    btSelecionado = null;
                    btVerificar.setClickable(false);
                    btVerificar.setBackgroundColor(parseColor("#8E8C8C"));
                }


            }
        });

        btQuestao1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btSelecionado != btQuestao1b){
                    btSelecionado = btQuestao1b;

                    btQuestao1a.setBackgroundColor(parseColor("#668cff"));
                    btQuestao1b.setBackgroundColor(parseColor("#66e0ff"));
                    btQuestao1c.setBackgroundColor(parseColor("#668cff"));
                    btQuestao1d.setBackgroundColor(parseColor("#668cff"));

                    btVerificar.setClickable(true);
                    btVerificar.setBackgroundColor(parseColor("#bfff00"));
                }
                else{
                    btQuestao1b.setBackgroundColor(parseColor("#668cff"));
                    btSelecionado = null;
                    btVerificar.setClickable(false);
                    btVerificar.setBackgroundColor(parseColor("#8E8C8C"));
                }

            }
        });

        btQuestao1c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btSelecionado != btQuestao1c){
                    btSelecionado = btQuestao1c;

                    btQuestao1a.setBackgroundColor(parseColor("#668cff"));
                    btQuestao1b.setBackgroundColor(parseColor("#668cff"));
                    btQuestao1c.setBackgroundColor(parseColor("#66e0ff"));
                    btQuestao1d.setBackgroundColor(parseColor("#668cff"));

                    btVerificar.setClickable(true);
                    btVerificar.setBackgroundColor(parseColor("#bfff00"));
                }
                else{
                    btQuestao1c.setBackgroundColor(parseColor("#668cff"));
                    btSelecionado = null;
                    btVerificar.setClickable(false);
                    btVerificar.setBackgroundColor(parseColor("#8E8C8C"));
                }
            }
        });

        btQuestao1d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btSelecionado != btQuestao1d){
                    btSelecionado = btQuestao1d;

                    btQuestao1a.setBackgroundColor(parseColor("#668cff"));
                    btQuestao1b.setBackgroundColor(parseColor("#668cff"));
                    btQuestao1c.setBackgroundColor(parseColor("#668cff"));
                    btQuestao1d.setBackgroundColor(parseColor("#66e0ff"));

                    btVerificar.setClickable(true);
                    btVerificar.setBackgroundColor(parseColor("#bfff00"));
                }
                else{
                    btQuestao1d.setBackgroundColor(parseColor("#668cff"));
                    btSelecionado = null;
                    btVerificar.setClickable(false);
                    btVerificar.setBackgroundColor(parseColor("#8E8C8C"));
                }
            }
        });

        btVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btVerificar.getText().equals("Verificar")) {
                    verificarResp((String) btSelecionado.getText());
                    btQuestao1a.setClickable(false);
                    btQuestao1b.setClickable(false);
                    btQuestao1c.setClickable(false);
                    btQuestao1d.setClickable(false);
                }
                else{
                    proxPergunta();
                    btSelecionado = null;
                    btVerificar.setClickable(false);
                    btVerificar.setText("Verificar");
                    btVerificar.setBackgroundColor(parseColor("#8E8C8C"));
                    btQuestao1a.setBackgroundColor(parseColor("#668cff"));
                    btQuestao1b.setBackgroundColor(parseColor("#668cff"));
                    btQuestao1c.setBackgroundColor(parseColor("#668cff"));
                    btQuestao1d.setBackgroundColor(parseColor("#668cff"));

                    btQuestao1a.setClickable(true);
                    btQuestao1b.setClickable(true);
                    btQuestao1c.setClickable(true);
                    btQuestao1d.setClickable(true);

                }

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void carregarPerguntas(){
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.perguntassql);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String linha;

            while((linha = bufferedReader.readLine()) != null){
                linhas.add(linha);
            }

            bufferedReader.close();
            inputStream.close();


            ordem[0] = -1;
            for (int i = 0; i < 30; i++){
                Random random = new Random();
                int num = random.nextInt(30);

                int diferente = 0;

                for (int j = 0; j < i; j++){
                    if (ordem[j] != num){
                        diferente++;
                    }
                }

                if (diferente >= i){
                    ordem[i] = num;
                }
                else{
                    i--;
                }

            }


        } catch (Exception e) {
            Toast.makeText(TesteSqlActivity.this, "Erro", Toast.LENGTH_SHORT).show();
        }

        proxPergunta();
    }

    private void proxPergunta(){
        if (!linhas.isEmpty()){
            if (numQuestao < 10){
                String pergunta = linhas.get(ordem[numQuestao]);
                exibirPergunta(pergunta);
                numQuestao++;
            }
            else{
                Toast.makeText(TesteSqlActivity.this, "Teste Terminado", Toast.LENGTH_SHORT).show();
                Toast.makeText(TesteSqlActivity.this, "Total de acertos: " + Global.acertosSql, Toast.LENGTH_SHORT).show();
                Toast.makeText(TesteSqlActivity.this, "Total de erros: " + Global.errosSql, Toast.LENGTH_SHORT).show();
                Toast.makeText(TesteSqlActivity.this, "Pontuação total: " + (Global.acertosSql - Global.errosSql * 0.2), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(TesteSqlActivity.this, ResultadoTesteActivity.class);
                startActivity(intent);

                ResultadoTesteActivity.quantAcertos = Global.acertosSql;
                ResultadoTesteActivity.quantErros = Global.errosSql;

                finish();
            }

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

            tvQuestaoNum.setText("Questao "+ (numQuestao + 1)+":");
            tvQuestaoTexto.setText(pergunta);

            btQuestao1a.setText(respA);
            btQuestao1b.setText(respB);
            btQuestao1c.setText(respC);
            btQuestao1d.setText(respD);
            /*
            btQuestao1a.setOnClickListener(v -> verificarResp(btQuestao1a.getText().toString(), btQuestao1a.getId()));
            btQuestao1b.setOnClickListener(v -> verificarResp(btQuestao1b.getText().toString(), btQuestao1b.getId()));
            btQuestao1c.setOnClickListener(v -> verificarResp(btQuestao1c.getText().toString(), btQuestao1c.getId()));
            btQuestao1d.setOnClickListener(v -> verificarResp(btQuestao1d.getText().toString(), btQuestao1d.getId()));*/
        }
    }

    private void verificarResp(String repostaEsc){
        if (repostaEsc.equals(respCerta)){
            Toast.makeText(TesteSqlActivity.this, "Acertou!", Toast.LENGTH_SHORT).show();
            btVerificar.setBackgroundColor(parseColor("#80ff00"));
            btSelecionado.setBackgroundColor(parseColor("#80ff00"));

            Global.acertosSql++;
        }
        else{
            Toast.makeText(TesteSqlActivity.this, "Errou!", Toast.LENGTH_SHORT).show();

            btVerificar.setBackgroundColor(parseColor("#ff0000"));
            btSelecionado.setBackgroundColor(parseColor("#ff0000"));

            if(btQuestao1a != btSelecionado && btQuestao1a.getText().equals(respCerta)){
                btQuestao1a.setBackgroundColor(parseColor("#80ff00"));
            }
            else if(btQuestao1b != btSelecionado && btQuestao1b.getText().equals(respCerta)){
                btQuestao1b.setBackgroundColor(parseColor("#80ff00"));
            }
            else if(btQuestao1c != btSelecionado && btQuestao1c.getText().equals(respCerta)){
                btQuestao1c.setBackgroundColor(parseColor("#80ff00"));
            }
            else if(btQuestao1d != btSelecionado && btQuestao1d.getText().equals(respCerta)){
                btQuestao1d.setBackgroundColor(parseColor("#80ff00"));
            }

            Global.errosSql++;
        }
        btVerificar.setText("Próxima");

    }
}