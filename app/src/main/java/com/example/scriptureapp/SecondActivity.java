package com.example.scriptureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
private Scripture _scripture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
         _scripture =(Scripture) intent.getSerializableExtra("message");
        Log.d("SecondActivity","Received intent with "+ _scripture.toString());
        TextView tv = findViewById(R.id.rcvd_scripture);
        tv.setText(_scripture.toString());

    }
   public void Save(View view){
        SharedPreferences mPrefs = getSharedPreferences("Scripture", 0);
        SharedPreferences.Editor editor = mPrefs.edit();
       editor.putString("Book", _scripture.getBook());
       editor.putInt("Chapter",_scripture.getChapter());
       editor.putInt("Verse",_scripture.getVerse());
       editor.commit();
       Toast.makeText(SecondActivity.this,"saved successfully.",Toast.LENGTH_LONG).show();
    }
}