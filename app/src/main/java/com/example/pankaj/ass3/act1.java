package com.example.pankaj.ass3;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class act1 extends AppCompatActivity {

    EditText userName;
    EditText password;
    TextView dataView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1);
        setTitle("LOGIN");
        userName = (EditText) findViewById(R.id.userNameInput);
        password = (EditText) findViewById(R.id.passwordInput);
        dataView = (TextView) findViewById(R.id.dataTextView);

    }
    // Lesson 64
    //Save login info
    public void saveData(View view)
    {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = loginData.edit();
        editor.putString("userName", userName.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.apply();

        Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();
    }

    public void getData(View view){
        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = loginData.getString("userName", "");
        String pw = loginData.getString("password","");
        String msg = "Saved User Name: " + name + "\nSaved Password: " + pw;
        dataView.setText(msg);
    }
}
