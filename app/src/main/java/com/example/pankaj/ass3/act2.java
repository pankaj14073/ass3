package com.example.pankaj.ass3;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class act2 extends AppCompatActivity {
    String msg = "Android : ";
    String filename="myfile.txt";
    private String filepath = "myfilestorage";
    File myInternalFile;
    File myExternalFile;
    EditText data;
    TextView dataView;
    Button savee;
    String m ="android:version beta2:id:3346:";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
        setTitle("Store Data");
        data = (EditText) findViewById(R.id.data);
        dataView = (TextView) findViewById(R.id.dataTextView);
        savee=(Button) findViewById(R.id.savee);
        dataView.setText(m+"app storage opened \n");


    }

    public void saveDatai(View v)
    {

        Log.d(msg, "daving data to intenal " );
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);


        String content = data.getText().toString();
        data.setText("");
        String t= dataView.getText().toString();
      //  dataView.setText(t+"\n"+m+content+ "\n");

        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File directory = contextWrapper.getDir(filepath, Context.MODE_PRIVATE);
        myInternalFile = new File(directory , filename);

        try {
            FileOutputStream fos = new FileOutputStream(myInternalFile,true);
            fos.write(content.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        t= dataView.getText().toString();
        dataView.setText(t+"\n"+m+"MySampleFile.txt saved to Internal Storage..."+ "\n");

String myData="";
        try {
            FileInputStream fis = new FileInputStream(myInternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        t= dataView.getText().toString();
        dataView.setText(t+"\n"+m+"OUTPUT "+ "\n" +myData);

    Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();
    }


    public void saveDatae(View v)
    {
        Log.d(msg, "daving data to Externel " );
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);


        String content = data.getText().toString();
        data.setText("");
        String t= dataView.getText().toString();
        //  dataView.setText(t+"\n"+m+content+ "\n");

        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File directory = contextWrapper.getDir(filepath, Context.MODE_PRIVATE);
        myInternalFile = new File(directory , filename);

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            savee.setEnabled(false);
        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }


        try {
            FileOutputStream fos = new FileOutputStream(myExternalFile,true);
            fos.write(content.getBytes());
            t= dataView.getText().toString();
            dataView.setText(t+"\n"+m+"writing to EXTERNAL STORAGE ");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String myData="";

        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        t= dataView.getText().toString();
        dataView.setText(t+"\n"+m+"OUTPUT(External) : "+myData);

        Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();

    }
    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

}
