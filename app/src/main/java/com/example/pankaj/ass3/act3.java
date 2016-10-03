package com.example.pankaj.ass3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;


public class act3 extends AppCompatActivity
{
    private static final String TABLE_SHOPS = "shops";
    String msg="Android";
    TextView dataView;
    Button delete;
    EditText id;
    @Override

    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3);
        setTitle("DataBase");
        dataView = (TextView) findViewById(R.id.dataTextView);
        delete =(Button)findViewById(R.id.delete);
        id=(EditText) findViewById(R.id.id);
    }
    public void newdata(View v)
    {
        Intent myIntent = new Intent(act3.this,
                newdata.class);
        Log.d(msg, "new data act " );
        startActivity(myIntent);

    }
    public void show(View v)
    {int i=1;
        db db = new db(this);
        List<shop> shops = db.getAllShops();
        String log="";
        for (shop shop : shops)
        {
          log = log+"Id: " + i + " ,Name: " + shop.getName() + " ,Owner: " + shop.getOwner() + " ,Address: " + shop.getAddress()+"\n";
            i++;
        }
        String  t= dataView.getText().toString();
        dataView.setText(t+"DataBase : "+"\n"+log);
    }
    public void delall(View v)
    {
        db db = new db(this);
        Log.d(msg, "DELETING DATABASE  " );
        db.delall();
    }
    public void delete (View v)
    {
        int i=Integer.parseInt(id.getText().toString());
        System.out.println("XXXXXXXXXXXXX  : " +i);
        db db = new db(this);
        shop shop= db.getShop(i);
        if(shop==null)
        {
            String  t= dataView.getText().toString();
            dataView.setText(t+"DataBase : "+"\n"+"NO SHOP FOUND");
        }
        else
        {
            String  t= dataView.getText().toString();
            dataView.setText(t+"DataBase : "+"\n"+"Deleting Shop : "+"\n"+"Id: " + i + " ,Name: " + shop.getName() + " ,Owner: " + shop.getOwner() + " ,Address: " + shop.getAddress()+"\n");
                db.deleteShop(shop);
        }

    }
}

