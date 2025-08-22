package com.example.calculadorahipotenusa;

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

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    Button btCalcular, btLimpar;

    EditText edCatetoA, edCatetoB;


    TextView tvHipotenusa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btCalcular = findViewById(R.id.btCalcular);
        btLimpar = findViewById(R.id.btLimpar);

        edCatetoA = findViewById(R.id.edCatetoA);
        edCatetoB = findViewById(R.id.edCatetoB);


        tvHipotenusa = findViewById(R.id.tvHipotenusa);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double catA, catB, hipo;

                catA = Double.parseDouble(edCatetoA.getText().toString());
                catB = Double.parseDouble(edCatetoB.getText().toString());

                hipo = Math.sqrt(catA * catA + catB * catB);

                DecimalFormat df = new DecimalFormat("#.##");


                tvHipotenusa.setText(df.format(hipo));


            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edCatetoA.setText("");
                edCatetoB.setText("");
                tvHipotenusa.setText("------------");
            }
        });






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}