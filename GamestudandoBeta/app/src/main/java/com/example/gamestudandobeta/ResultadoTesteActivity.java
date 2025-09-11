package com.example.gamestudandobeta;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class ResultadoTesteActivity extends AppCompatActivity {


    PieChart pieGraficoResultado;

    Button btFechar;

    TextView tvNotaResultado;
    public static int quantAcertos, quantErros;

    androidx.constraintlayout.widget.ConstraintLayout main;

    public static Drawable corFundo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado_teste);

        btFechar = findViewById(R.id.btFechar);

        main = findViewById(R.id.main);

        main.setBackground(corFundo);

        pieGraficoResultado = findViewById(R.id.pieGraficoResultado);

        tvNotaResultado = findViewById(R.id.tvNotaResultado);

        ArrayList<PieEntry> entradas = new ArrayList<>();
        entradas.add(new PieEntry(quantAcertos, "Acertos"));
        entradas.add(new PieEntry(quantErros, "Erros"));

        PieDataSet pieDataSet = new PieDataSet(entradas, "Resultado Teste");

        pieDataSet.setColors(new int[]{Color.GREEN, Color.RED});
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(16f);


        PieData pieData = new PieData(pieDataSet);
        pieGraficoResultado.setData(pieData);

        pieGraficoResultado.setUsePercentValues(true);
        pieGraficoResultado.getDescription().setEnabled(false);
        pieGraficoResultado.setCenterText("Resultado do Teste");
        pieGraficoResultado.setEntryLabelColor(Color.WHITE);
        pieGraficoResultado.animateY(1000);


        pieGraficoResultado.invalidate();

        btFechar.setOnClickListener(v -> finish());

        if(quantAcertos - quantErros * 0.2 < 0){
            tvNotaResultado.setText("0");
        }
        else{
            tvNotaResultado.setText(String.valueOf(quantAcertos - quantErros * 0.2));
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}