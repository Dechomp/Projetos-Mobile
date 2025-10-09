package com.example.busultra;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

public class BlocoPassagem extends LinearLayout {
    Button escolherPassagem;
    TextView tvHorarioPartida, tvHorarioChegada;

    TextView tvOrigem, tvDestino;

    TextView tvPreco;

    public BlocoPassagem(Context context, String horaPartida, String horaChegada, String origem, String destino,String preco) {
        super(context);
        tvHorarioChegada.setText(horaChegada);
        tvHorarioPartida.setText(horaPartida);
        tvOrigem.setText(origem);
        tvDestino.setText(destino);
        tvPreco.setText(preco);

    }
}
