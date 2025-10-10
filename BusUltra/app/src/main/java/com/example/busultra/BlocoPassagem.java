package com.example.busultra;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

public class BlocoPassagem extends MainActivity {

    //Criando os botões
    Button btEscolherPassagem, btMaisInfo;

    //Criando as Views
    TextView tvHorarioPartida, tvHorarioChegada;

    TextView tvOrigem, tvDestino;

    TextView tvPreco;
    //Construtor
    public BlocoPassagem(Context context, TextView horaPartida, TextView horaChegada, TextView origem, TextView destino,TextView preco,
    Button escolherPassagem, Button maisInfo) {
        //Configura apenas os textos
        tvHorarioChegada = horaChegada;
        tvHorarioPartida = horaPartida;
        tvOrigem = origem;
        tvDestino = destino;
        tvPreco = preco;
        btEscolherPassagem = escolherPassagem;
        btMaisInfo = maisInfo;
    }
    //Programação dos botões




}
