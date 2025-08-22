package com.example.calculadoradeidade;

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

public class MainActivity extends AppCompatActivity {
    Button btCalcular, btLimpar;

    EditText edAnos, edMeses, edDias;

    TextView tvIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btCalcular = findViewById(R.id.btCalcular);
        btLimpar = findViewById(R.id.btLimpar);

        edAnos = findViewById(R.id.edAnos);
        edMeses = findViewById(R.id.edMeses);
        edDias = findViewById(R.id.edDias);

        tvIdade = findViewById(R.id.tvIdade);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int anos, meses, dias, idade;

                anos = Integer.parseInt(edAnos.getText().toString());
                meses = Integer.parseInt(edMeses.getText().toString());
                dias = Integer.parseInt(edDias.getText().toString());

                idade = anos * 365 + meses * 30 + dias;

                tvIdade.setText(String.valueOf(idade));
            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edAnos.setText("");
                edMeses.setText("");
                edDias.setText("");

                tvIdade.setText("------------");
            }
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}