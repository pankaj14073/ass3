package com.example.pankaj.ass3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class newdata extends AppCompatActivity
{
int i=1;
    EditText name;
    EditText owner;
    EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        i++;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newdata);
        name = (EditText) findViewById(R.id.name);
        owner = (EditText) findViewById(R.id.owner);
        address = (EditText) findViewById(R.id.address);
    }


    public void saveData(View v)
    {
        db dbase = new db(this);
        String n =name.getText().toString();
        String o =owner.getText().toString();
        String a =address.getText().toString();
        Log.d("Insert: ", "Inserting ..");
        String id= Integer.toString(i);
        dbase.addShop(new shop(n,o,a));
        name.setText("");
        owner.setText("");
        address.setText("");
        Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();
    }
}

/*
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class newdata extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      db db = new db(this);

// Inserting shop/Rows
        Log.d("Insert: ", "Inserting ..");
        db.addShop(new shop(1,"Dockers", " 475 Brannan St #330 San Francisco CA 94107", "United States"));
        db.addShop(new shop(2,"Dunkin Donuts", "White Plains", "NY 10601"));
        db.addShop(new shop(3,"Pizza Porlar", "North West Avenue", "Boston  USA"));
        db.addShop(new shop(4,"Town Bakers", "Beverly Hills", "CA 90210 USA"));

        Log.d("Reading: ", "Reading all shops..");
        List<shop> shops = db.getAllShops();
        for (shop shop : shops)
        {

            String log = "Id: " + shop.getId() + " ,Name: " + shop.getName() + " ,Address: " + shop.getAddress();
            Log.d("shop: : ", log);
        }
    }
}*/