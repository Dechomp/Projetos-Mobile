package com.example.multtela;

import static android.widget.Toast.*;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    Button btOK, btCancel;

    EditText edUser, edSenha;

    TextView tvSituacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        btOK = findViewById(R.id.btOK);
        btCancel = findViewById(R.id.btCancel);


        edUser = findViewById(R.id.edUser);
        edSenha = findViewById(R.id.edSenha);

        tvSituacao = findViewById(R.id.tvSituacao);
        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user;

                user = edUser.getText().toString();
                if (user.equals("Adm")){

                    String senha;

                    senha = edSenha.getText().toString();

                    if(senha.equals("123456")){
                        Intent telaPrincipal;

                        telaPrincipal = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(telaPrincipal);
                        Toast.makeText(LoginActivity.this, "Login feito com sucesso¹", LENGTH_SHORT).show();

                        finish();
                    }
                    else{

                        tvSituacao.setText("Senha Incorreta");
                        Toast.makeText(LoginActivity.this, "Senha Incorreta", LENGTH_SHORT).show();

                    }


                }
                else{
                    tvSituacao.setText("Usuário não encontrado");
                    Toast.makeText(LoginActivity.this, "Usuário não encontrado", LENGTH_SHORT).show();
                }

            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSituacao.setText("----------");
                edUser.setText("");
                edUser.setHint("Digite aqui...");

                edSenha.setText("");
                edSenha.setHint("Digite aqui...");
            }
        });

        edUser.setOnFocusChangeListener(((v, hasFocus) -> {
            if(!hasFocus){
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        }));

        edSenha.setOnFocusChangeListener(((v, hasFocus) -> {
            if(!hasFocus){
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        }));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}