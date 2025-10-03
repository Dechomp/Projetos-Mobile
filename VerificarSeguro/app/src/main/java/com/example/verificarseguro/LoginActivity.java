package com.example.verificarseguro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    Button btSobre, btLogar;

    EditText edEmail, edSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);


        btLogar = findViewById(R.id.btLogar);
        btSobre = findViewById(R.id.btSobreApp);

        edEmail = findViewById(R.id.edEmail);
        edSenha = findViewById(R.id.edSenha);


        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, senha;

                email = edEmail.getText().toString();
                senha = edSenha.getText().toString();

                if(email.isEmpty() || senha.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Campos Vazios", Toast.LENGTH_SHORT).show();
                }
                else if (email.equals("dechomp@gmail.com")){
                        if(senha.equals("Julio1312")){
                            Toast.makeText(LoginActivity.this, "Bem-vindo de Volta!", Toast.LENGTH_SHORT).show();

                            Intent telaPrincipal = new Intent(LoginActivity.this, MainActivity.class);

                            startActivity(telaPrincipal);

                            finish();
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Senha Incorreta", Toast.LENGTH_SHORT).show();
                        }
                }
                else{
                    Toast.makeText(LoginActivity.this, "Email ou senha incorreta", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teaSobre = new Intent(LoginActivity.this, SobreActivity.class);

                startActivity(teaSobre);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}