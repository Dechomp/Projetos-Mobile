package com.example.gerarnumerosaletorios;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    Button btGerar, btLimpar;


    EditText edQuantidade;


    TextView tvNumeros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btGerar = findViewById(R.id.btGerar);
        btLimpar = findViewById(R.id.btLimpar);

        edQuantidade = findViewById(R.id.edQuantidade);

        tvNumeros = findViewById(R.id.tvNumeros);


        btGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quant;

                try{
                    quant = Integer.parseInt(edQuantidade.getText().toString());

                    Set nums = new TreeSet();
                    Random random = new Random();
                    for (int i = 0; i < quant; i++){
                        nums.add(random.nextInt(100));
                    }

                    tvNumeros.setText(String.valueOf(nums));
                }
                catch (Exception ex){
                    tvNumeros.setText("Campos nulos ou inválidos, digite novamente!");
                }



            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edQuantidade.setText("");
                tvNumeros.setText("------------");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}