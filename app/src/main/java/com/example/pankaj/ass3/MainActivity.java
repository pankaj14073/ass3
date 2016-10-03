package com.example.pankaj.ass3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String msg = "Android : ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void function1(View arg0)
    {
        // Start NewActivity.class
        Intent myIntent = new Intent(MainActivity.this,
                act1.class);
        Log.d(msg, "function1 is called " );
        startActivity(myIntent);

    }
    public void function2(View arg0)
    {
        // Start NewActivity.class
        Intent myIntent = new Intent(MainActivity.this,
                act2.class);
        Log.d(msg, "function2 is called " );
        startActivity(myIntent);

    }
    public void function3(View arg0)
    {
        // Start NewActivity.class
        Intent myIntent = new Intent(MainActivity.this,
                act3.class);
        Log.d(msg, "function2 is called " );
        startActivity(myIntent);

    }



}
