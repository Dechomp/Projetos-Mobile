package com.example.busultra;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    Button btEscolherData;

    EditText edDataViagem;

    Spinner spOrigem, spDestino;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Botões
        btEscolherData = findViewById(R.id.btEscolherData);

        //Textos editáveis
        edDataViagem = findViewById(R.id.edDataViagem);

        //Spinners
        spOrigem = findViewById(R.id.spOrigem);
        spDestino = findViewById(R.id.spDestino);

        //Lista de origens
        ArrayList<String> origens = new ArrayList<>();
        origens.add("Selecione...");
        origens.add("Santana de Parnaíba");
        origens.add("Barueri");
        origens.add("São Paulo");

        //Lista de destinos
        ArrayList<String> destinos = new ArrayList<>();
        destinos.add("Selecione...");
        destinos.add("Santana de Parnaíba");
        destinos.add("Cajamar");
        destinos.add("RIo de Janeiro");


        //Quando clicar no botão btEscolherData
        btEscolherData.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //Crio uma variável do tipo calendário
               Calendar calendario = Calendar.getInstance();

               //Crio uma vaqriável para cada informação de data
               int dia, mes, ano;

               //Cada uma recebe o tipo da informação
               dia = calendario.get(Calendar.DAY_OF_MONTH);
               mes = calendario.get(Calendar.MONTH);
               ano = calendario.get(Calendar.YEAR);

               //Cria o calendário flutuante
               DatePickerDialog calendarioFlutuante = new DatePickerDialog(
                       //Nesta tela
                       MainActivity.this,
                       //Os parâmetros que irá usar
                       (view, year, month, dayOfMonth) -> {
                           //Assim que der OK, vai criar o texto da data
                           String dataEsc = dayOfMonth + "/" + (month + 1) + "/" + year;
                           //Mostra a mensagem da data escolhida
                           Toast.makeText(MainActivity.this, "Data escolhida: " + dataEsc, Toast.LENGTH_SHORT).show();

                           //Troca o texto do edDataViagem com fim de armazenamento
                           edDataViagem.setText(dataEsc);
                       },
                       //Referente a ordem dos parâmetros
                       ano, mes, dia
               );
                //Mostra o calendário na tela
               calendarioFlutuante.show();
           }
        });

        /*
        Para adicionar a lista ao sppiner, teremos que criar um adaptador
        /
        Como temos duas listas, iremos criar uma funç~~ao para isto
        ...
        Agora é só chamar a função
        */
        try {
            spOrigem.setAdapter(adapatarLista(origens));
            spDestino.setAdapter(adapatarLista(destinos));
        }
        catch (Exception ex){
            Toast.makeText(MainActivity.this, "Erro: " + ex, Toast.LENGTH_SHORT).show();
        }

        //Agora configurar os cliques

        spOrigem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            //Asim que um item for selecionado e não tiver escrito "Selecione", mostra o destino escolhido
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String origem = parent.getItemAtPosition(position).toString();
                if (! origem.contains("Selecione")){
                    Toast.makeText(MainActivity.this, "Origem selecionada: " + origem, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Nada por enquanto
            }
        });

        spDestino.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String destino = parent.getItemAtPosition(position).toString();
                if(!destino.contains("Selecione")){
                    Toast.makeText(MainActivity.this, "Destino selecionado: " + destino, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Nada por enquanto
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //Função para adaptar uma lista

    private ArrayAdapter adapatarLista(ArrayList lista){

        //Cria um array adaptado
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                //Tela atual
                MainActivity.this,
                //Formato
                android.R.layout.simple_spinner_item,
                //Array a aser adaptada
                lista
        );
        //Formata como vai aparecer
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adaptador;

    }


}