package vamsee.application.userfeedback;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton selected;
    CheckBox heptic, amd, hdd, ram;
    RatingBar stars;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    Switch mail;
    DatePicker datePicker;
    String[] suggestions = {"amazing", "a", "best Product", "better than", "worst", "waste", "Product", "could", "be", "better", "great"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        heptic = findViewById(R.id.checkbox1);
        amd = findViewById(R.id.checkbox3);
        hdd = findViewById(R.id.checkbox2);
        ram = findViewById(R.id.checkbox4);
        stars = findViewById(R.id.stars);
        multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);
        mail = findViewById(R.id.Switch);
        datePicker = findViewById(R.id.datePicker);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, suggestions);
        multiAutoCompleteTextView.setAdapter(arrayAdapter);
        multiAutoCompleteTextView.setThreshold(1);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    public void feedback(View view) {
        StringBuilder output = new StringBuilder();

        //Radio Button :
        int selectId = radioGroup.getCheckedRadioButtonId();
        selected = findViewById(selectId);
        if(selectId == -1){
            Toast.makeText(this, "please check any one of the radio button...", Toast.LENGTH_SHORT).show();
        }
        else if (selectId == R.id.yes){
            output.append("You liked the product.\n");
        }
        else{
            output.append("You did not like the product.\n");
        }

        //Checkbox :
        output.append("\nFeatures liked: \n");
        if(heptic.isChecked()){
            output.append("-heptic motors\n");
        }
        if(amd.isChecked()){
            output.append("-AMD Zen 2 CPU\n");
        }
        if(hdd.isChecked()){
            output.append("-HDD 825GB\n");
        }
        if(ram.isChecked()){
            output.append("-RAM 16GB GDDR6\n");
        }


        //Rating Bar :
        output.append("\nYour Rating : "+stars.getRating()+"\n");

        //multiautoCompleteTextView :
        output.append("\nYour Review : "+multiAutoCompleteTextView.getText().toString()+"\n\n");

        //switch :
        if (mail.isChecked()){
            output.append("mail sent\n\n");
        }
        else {
            output.append("your response will not be sent in mail\n\n");
        }

        //datePicker :
        output.append("Delivery date : " + datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear());


        Toast.makeText(this, output.toString(), Toast.LENGTH_LONG).show();

    }



}