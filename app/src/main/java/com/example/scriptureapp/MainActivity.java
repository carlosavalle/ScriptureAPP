package com.example.scriptureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SendScripture(View view){
        //Scripture scripture = new Scripture(findViewById(R.id.input_book).toString(),Integer.parseInt(findViewById(R.id.input_chapter).toString()),Integer.parseInt(findViewById(R.id.input_verse).toString()));
        Scripture scripture = new Scripture(((EditText) findViewById(R.id.input_book)).getText().toString(),Integer.parseInt(((EditText) findViewById(R.id.input_chapter)).getText().toString()),Integer.parseInt(((EditText) findViewById(R.id.input_verse)).getText().toString()));
       // Scripture scripture = new Scripture("BK",1,2);
         Intent intent = new Intent(this, SecondActivity.class);
         intent.putExtra("message", scripture);
         Log.d("MainActivity","About to create intent with "+scripture.toString());
         startActivity(intent);

    }

    public void LoadScripture(View view){

        SharedPreferences mPrefs = getSharedPreferences("Scripture", 0);

        ((EditText) findViewById(R.id.input_book)).setText(mPrefs.getString("Book", ""));
        ((EditText) findViewById(R.id.input_chapter )).setText(""+mPrefs.getInt("Chapter",0 ));
        ((EditText) findViewById(R.id.input_verse)).setText(""+mPrefs.getInt("Verse",0));

    }
}