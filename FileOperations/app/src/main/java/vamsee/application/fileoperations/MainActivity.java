package vamsee.application.fileoperations;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 100;
    Button newFile, readFlie, writeFile, deleteFile, newFileExt, writeFileExt, Internal, External;
    TextView readOutput;
    EditText fileName, inputText;
    ConstraintLayout internal, external;
    boolean checkWrite = true;
    boolean checkFile = true;
    boolean isInternal = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newFile = findViewById(R.id.createNewExt);
        newFileExt = findViewById(R.id.createNewBtn);
        readFlie = findViewById(R.id.readExt);
        writeFile = findViewById(R.id.writeExt);
        writeFileExt = findViewById(R.id.writeExtButton);
        deleteFile = findViewById(R.id.deleteFile);
        Internal = findViewById(R.id.Internal);
        External = findViewById(R.id.External);

        readOutput = findViewById(R.id.readOp);
        fileName = findViewById(R.id.fileName);
        inputText = findViewById(R.id.inputText);

        internal = findViewById(R.id.Intenal_layout);
        external = findViewById(R.id.External_layout);

        Internal.setBackgroundColor(Color.BLACK);
        External.setBackgroundColor(Color.GRAY);


    }

    public void ShowInternalLayout(View view) {
        if (!isInternal){
            internal.setVisibility(View.VISIBLE);
            external.setVisibility(View.GONE);
            Internal.setBackgroundColor(Color.BLACK);
            External.setBackgroundColor(Color.GRAY);
            isInternal = true;
        }

    }

    public void ShowExternalLayout(View view) {
        if (isInternal){
            internal.setVisibility(View.GONE);
            external.setVisibility(View.VISIBLE);
            External.setBackgroundColor(Color.BLACK);
            Internal.setBackgroundColor(Color.GRAY);
            isInternal = false;
        }

    }

    public void createNewFile(View view) throws IOException {
        try {
            if (checkExternalMedia()) {
                File sdCard = Environment.getExternalStorageDirectory();
                File dir = new File(sdCard.getAbsolutePath() + File.separator + "Classroom Assignment" + File.separator);
                dir.mkdirs();
                File file = new File(dir, fileName.getText().toString()+".txt");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(readOutput.getText().toString().getBytes());
                fileOutputStream.close();
                Toast.makeText(getApplicationContext(), "File created Successfully", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "External Storage unavailable", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }


    public void showNewFileBtn(View view) {
        if(checkFile){
            fileName.setVisibility(View.VISIBLE);
            newFileExt.setVisibility(View.VISIBLE);
            checkFile = false;
        }
        else {
            fileName.setVisibility(View.GONE);
            newFileExt.setVisibility(View.GONE);
            checkFile = true;
        }
    }

    public void readFile(View view) {
        try {
            if (checkExternalMedia()) {
                File sdCard = Environment.getExternalStorageDirectory();
                File dir = new File(sdCard.getAbsolutePath() + File.separator + "Classroom Assignment" + File.separator);
                File file = new File(dir, "vamseevk.txt");
                StringBuilder result = new StringBuilder();
                String line = "";
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while ((line = bufferedReader.readLine()) != null) {
                    result.append(line);
                }
                readOutput.setText(result.toString());
            } else {
                Toast.makeText(getApplicationContext(), "External Storage unavailable", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void ShowWriteBtn(View view) {
        if(checkWrite){
            inputText.setVisibility(View.VISIBLE);
            writeFileExt.setVisibility(View.VISIBLE);
            checkWrite = false;
        }
        else {
            inputText.setVisibility(View.GONE);
            writeFileExt.setVisibility(View.GONE);
            checkWrite = true;
        }
    }

    public void writeContent(View view) {
        try {
            if (checkExternalMedia()) {
                File sdCard = Environment.getExternalStorageDirectory();
                File dir = new File(sdCard.getAbsolutePath() + File.separator + "Classroom Assignment" + File.separator);
                dir.mkdirs();
                File file = new File(dir, "vamseevk.txt");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(inputText.getText().toString().getBytes());
                fileOutputStream.close();
                Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
                inputText.setText("");
            } else {
                Toast.makeText(getApplicationContext(), "External Storage unavailable", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void deleteFile(View view) {
        try {
            String folder = getApplication().getFilesDir().getAbsolutePath() + File.separator + "classroom Assignment";
            File dir = new File( getApplication().getFilesDir().getAbsolutePath() + File.separator + "classroom Assignment");
            dir.mkdirs();
            File file = new File(dir, fileName.getText().toString()+".txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(readOutput.getText().toString().getBytes());
            fileOutputStream.close();
            if(file.exists()) {
                new AlertDialog.Builder(this).setIcon(R.drawable.ic_baseline_delete_forever_24)
                        .setTitle("Deleting File").setMessage("Are you sure you want to delete vamsee.txt?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                file.delete();
                                Toast.makeText(getApplicationContext(), "File deleted Successfully...", Toast.LENGTH_LONG).show();
                            }
                        }).setNegativeButton("No", null).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkExternalMedia() {
        boolean mExternalStorageAvailable = false;
        boolean mExternalStorageWriteable = false;
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            mExternalStorageAvailable = mExternalStorageWriteable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            mExternalStorageAvailable = true;
            mExternalStorageWriteable = false;
        } else {
            mExternalStorageAvailable = mExternalStorageWriteable = false;
        }
        return mExternalStorageAvailable && mExternalStorageWriteable;
    }
}