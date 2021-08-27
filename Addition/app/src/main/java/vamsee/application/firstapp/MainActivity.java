package vamsee.application.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View view) {
        EditText a = findViewById(R.id.a);
        EditText b = findViewById(R.id.b);
        int first = Integer.parseInt(a.getText().toString());
        int second = Integer.parseInt(b.getText().toString());
        TextView result = findViewById(R.id.result);
        result.setText("Result : " + (first + second));
    }
}