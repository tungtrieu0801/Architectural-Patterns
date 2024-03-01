package com.example.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edtEmail, edtPassword;
    private TextView textView;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail = findViewById(R.id.etEmail);
        edtPassword = findViewById(R.id.etPassword);
        textView = findViewById(R.id.textView);
        btnLogin = findViewById(R.id.button);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickLogin();
            }
        });
    }

    private void onClickLogin() {
        String strEmail = edtEmail.getText().toString().trim();
        String strPass = edtPassword.getText().toString().trim();
        User user =  new User(strEmail, strPass);
        textView.setVisibility(View.VISIBLE);
        if(user.isValidEmail() && user.isPassValid()) {
            textView.setText("Login success");
        }else {
            textView.setText("Login fail");

        }
    }
}