package com.example.busultra;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    Button btEscolherData;

    EditText edDataViagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

       btEscolherData = findViewById(R.id.btEscolherData);

       edDataViagem = findViewById(R.id.edDataViagem);

       btEscolherData.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Calendar calendario = Calendar.getInstance();

               int dia, mes, ano;

               dia = calendario.get(Calendar.DAY_OF_MONTH);
               mes = calendario.get(Calendar.MONTH);
               ano = calendario.get(Calendar.YEAR);

               DatePickerDialog calendarioFlutuante = new DatePickerDialog(
                       MainActivity.this,
                       ((view, year, month, dayOfMonth) -> {
                           String dataEsc = dayOfMonth + "/" + (month + 1) + "/" + year;
                       })
               );
           }
       });

        //Toast.makeText(MainActivity.this, "Data escolhida: " + dataEsc, Toast.LENGTH_SHORT).show();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}