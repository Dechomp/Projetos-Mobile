package com.example.gamestudandobeta;

import static android.graphics.Color.parseColor;

import android.content.Intent;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class TesteAndroidActivity extends AppCompatActivity {
    Button btQuestao1a, btQuestao1b, btQuestao1c, btQuestao1d, btVerificar, btSelecionado;

    TextView tvQuestaoNum, tvQuestaoTexto;

    String respCerta;

    int numQuestao = 0;

    ArrayList<String> linhas = new ArrayList<>();

    androidx.constraintlayout.widget.ConstraintLayout main;

    int[] ordem = new int[30];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teste_android);
        btQuestao1a = findViewById(R.id.btTesteAndroid1A);
        btQuestao1b = findViewById(R.id.btTesteAndroid1B);
        btQuestao1c = findViewById(R.id.btTesteAndroid1C);
        btQuestao1d = findViewById(R.id.btTesteAndroid1D);



        tvQuestaoNum = findViewById(R.id.tvQuestaoAndroidNum);
        tvQuestaoTexto = findViewById(R.id.tvQuestaoAndroidTexto);

        btVerificar = findViewById(R.id.btVerificarAndroid);

        main = findViewById(R.id.main);
        carregarPerguntas();

        Global.acertosAndroid = 0;
        Global.errosAndroid = 0;

        btQuestao1a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btSelecionado != btQuestao1a){
                    btSelecionado = btQuestao1a;

                    btQuestao1a.setBackgroundColor(parseColor("#66cc00"));
                    btQuestao1b.setBackgroundColor(parseColor("#00cc66"));
                    btQuestao1c.setBackgroundColor(parseColor("#00cc66"));
                    btQuestao1d.setBackgroundColor(parseColor("#00cc66"));

                    btVerificar.setClickable(true);
                    btVerificar.setBackgroundColor(parseColor("#bfff00"));

                }
                else{
                    btQuestao1a.setBackgroundColor(parseColor("#00cc66"));
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

                    btQuestao1a.setBackgroundColor(parseColor("#00cc66"));
                    btQuestao1b.setBackgroundColor(parseColor("#66cc00"));
                    btQuestao1c.setBackgroundColor(parseColor("#00cc66"));
                    btQuestao1d.setBackgroundColor(parseColor("#00cc66"));

                    btVerificar.setClickable(true);
                    btVerificar.setBackgroundColor(parseColor("#bfff00"));
                }
                else{
                    btQuestao1b.setBackgroundColor(parseColor("#00cc66"));
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

                    btQuestao1a.setBackgroundColor(parseColor("#00cc66"));
                    btQuestao1b.setBackgroundColor(parseColor("#00cc66"));
                    btQuestao1c.setBackgroundColor(parseColor("#66cc00"));
                    btQuestao1d.setBackgroundColor(parseColor("#00cc66"));

                    btVerificar.setClickable(true);
                    btVerificar.setBackgroundColor(parseColor("#bfff00"));
                }
                else{
                    btQuestao1c.setBackgroundColor(parseColor("#00cc66"));
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

                    btQuestao1a.setBackgroundColor(parseColor("#00cc66"));
                    btQuestao1b.setBackgroundColor(parseColor("#00cc66"));
                    btQuestao1c.setBackgroundColor(parseColor("#00cc66"));
                    btQuestao1d.setBackgroundColor(parseColor("#66cc00"));

                    btVerificar.setClickable(true);
                    btVerificar.setBackgroundColor(parseColor("#bfff00"));
                }
                else{
                    btQuestao1d.setBackgroundColor(parseColor("#00cc66"));
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
                    btQuestao1a.setBackgroundColor(parseColor("#00cc66"));
                    btQuestao1b.setBackgroundColor(parseColor("#00cc66"));
                    btQuestao1c.setBackgroundColor(parseColor("#00cc66"));
                    btQuestao1d.setBackgroundColor(parseColor("#00cc66"));

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
            InputStream inputStream = getResources().openRawResource(R.raw.perguntasandroid);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String linha;

            while((linha = bufferedReader.readLine()) != null){
                linhas.add(linha);
            }

            bufferedReader.close();
            inputStream.close();


            ordem[0] = -1;
            for (int i = 0; i < 15; i++){
            //for (int i = 0; i < 30; i++){
                Random random = new Random();
              //  int num = random.nextInt(30);
                int num = random.nextInt(15);
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
            Toast.makeText(TesteAndroidActivity.this, "Erro", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(TesteAndroidActivity.this, "Teste Terminado", Toast.LENGTH_SHORT).show();
                Toast.makeText(TesteAndroidActivity.this, "Total de acertos: " + Global.acertosAndroid, Toast.LENGTH_SHORT).show();
                Toast.makeText(TesteAndroidActivity.this, "Total de erros: " + Global.errosAndroid, Toast.LENGTH_SHORT).show();

                if (Global.acertosAndroid - Global.errosAndroid * 0.2 < 0){
                    Toast.makeText(TesteAndroidActivity.this, "Pontuação total: 0", Toast.LENGTH_SHORT).show();
                }
                else {
                    DecimalFormat df = new DecimalFormat("#.##");
                    Toast.makeText(TesteAndroidActivity.this, "Pontuação total: " + df.format(Global.acertosAndroid - Global.errosAndroid * 0.2), Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(TesteAndroidActivity.this, ResultadoTesteActivity.class);
                ResultadoTesteActivity.corFundo = main.getBackground();
                startActivity(intent);

                ResultadoTesteActivity.quantAcertos = Global.acertosAndroid;
                ResultadoTesteActivity.quantErros = Global.errosAndroid;

                finish();
            }

        }
    }
    private void exibirPergunta(String linha){
        String[] partes = linha.split(";");
        /*int[] ordemRespostas = new int[4];
        ordemRespostas[0] = -1;
        for (int i = 0; i < 15; i++){
            //for (int i = 0; i < 30; i++){
            Random random = new Random();
            //  int num = random.nextInt(30);
            int num = random.nextInt(1, 5);
            int diferente = 0;

            for (int j = 0; j < i; j++){
                if (ordem[j] != num){
                    diferente++;
                }
            }*/
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

        }
    }

    private void verificarResp(String repostaEsc) {
        if (repostaEsc.equals(respCerta)) {
            Toast.makeText(TesteAndroidActivity.this, "Acertou!", Toast.LENGTH_SHORT).show();
            btVerificar.setBackgroundColor(parseColor("#80ff00"));
            btSelecionado.setBackgroundColor(parseColor("#80ff00"));

            Global.acertosAndroid++;
        } else {
            Toast.makeText(TesteAndroidActivity.this, "Errou!", Toast.LENGTH_SHORT).show();

            btVerificar.setBackgroundColor(parseColor("#ff0000"));
            btSelecionado.setBackgroundColor(parseColor("#ff0000"));

            if (btQuestao1a != btSelecionado && btQuestao1a.getText().equals(respCerta)) {
                btQuestao1a.setBackgroundColor(parseColor("#80ff00"));
            } else if (btQuestao1b != btSelecionado && btQuestao1b.getText().equals(respCerta)) {
                btQuestao1b.setBackgroundColor(parseColor("#80ff00"));
            } else if (btQuestao1c != btSelecionado && btQuestao1c.getText().equals(respCerta)) {
                btQuestao1c.setBackgroundColor(parseColor("#80ff00"));
            } else if (btQuestao1d != btSelecionado && btQuestao1d.getText().equals(respCerta)) {
                btQuestao1d.setBackgroundColor(parseColor("#80ff00"));
            }

            Global.errosAndroid++;
        }
        btVerificar.setText("Próxima");
    }
}