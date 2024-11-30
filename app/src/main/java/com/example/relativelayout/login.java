package com.example.relativelayout;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button login = findViewById(R.id.login_btn);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
                String usr = email.getText().toString();
                String pass = password.getText().toString();
                if (usr.equals("admin") && pass.equals("admin")){
                    Toast.makeText(login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login.this, end.class));
                    finish();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                    builder.setMessage("login Gagal")
                            .setNegativeButton("Retry", null)
                            .create()
                            .show();

                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}