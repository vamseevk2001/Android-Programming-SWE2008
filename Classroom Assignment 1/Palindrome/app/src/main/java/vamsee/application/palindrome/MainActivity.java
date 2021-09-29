package vamsee.application.palindrome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    EditText input;
    private String filter = "~#^|$%&*!./@()_-+={}[]',";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        input = findViewById(R.id.input);
    }

    public void checkPalindrome(View view) {
        char[] charInput = input.getText().toString().toCharArray();
        int intLength = charInput.length;
        boolean isPalindrome = true;
        input.setFilters(new InputFilter[]
                {
                        new InputFilter() {
                            @Override
                            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                                if (source != null && filter.contains(("" + source))) {
                                    return "";
                                }
                                return null;
                            }

                        }
                });

        for (int i = 0; i < intLength / 2; i++) {
            if (charInput[i] != charInput[intLength - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            result.setText("Palindrome");
        } else {
            result.setText("NOT Palindrome");
        }
    }

}
