package vamsee.application.user_authentication_using_services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        TextView msg = findViewById(R.id.msg);
        String name = getIntent().getStringExtra("name");
        msg.setText("Hello ! "+ name);
    }
}