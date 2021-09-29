package vamsee.application.user_authentication_using_services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        EditText username = findViewById(R.id.uname);
        EditText password = findViewById(R.id.password);
        Intent intent = new Intent(this, UserAuthentication.class);
        intent.putExtra("username", username.getText().toString().trim());
        intent.putExtra("password", password.getText().toString().trim());
        startService(intent);
    }
}