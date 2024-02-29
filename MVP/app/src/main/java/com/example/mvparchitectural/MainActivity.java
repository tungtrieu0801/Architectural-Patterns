package com.example.mvparchitectural;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoginInterface {
    private EditText edtEmail, edtPassword;
    private TextView tvtResult;
    private Button btnLogin;

    private LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail = findViewById(R.id.etEmail);
        edtPassword = findViewById(R.id.etPassword);
        tvtResult = findViewById(R.id.tvresult);
        btnLogin = findViewById(R.id.button);

        loginPresenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lickLogin();
            }
        });
    }

    private void lickLogin() {
        String emailUser = edtEmail.getText().toString().trim();
        String passUser = edtPassword.getText().toString().trim();
        UserModel userModel = new UserModel(emailUser, passUser);
        loginPresenter.login(userModel);
    }

    @Override
    public void loginSuccess() {
        tvtResult.setVisibility(View.VISIBLE);
        tvtResult.setText("Login success");
    }

    @Override
    public void loginFail() {
        tvtResult.setVisibility(View.VISIBLE);
        tvtResult.setText("Login fail");
    }
}