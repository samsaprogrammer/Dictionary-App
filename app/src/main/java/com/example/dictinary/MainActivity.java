package com.example.dictinary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView actv_word;
    TextView tv_meaning;
    ArrayAdapter Ad;
    SQLiteDatabase db;
    DbManager dm;
    String query;
    ArrayList<String> al=new ArrayList<String>();

    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actv_word=findViewById(R.id.avtv_word);
        tv_meaning=findViewById(R.id.tv_meaning);
        dm=new DbManager(this);
        db=dm.getWritableDatabase();
        query="select word from dict";
        c=db.rawQuery(query, null);
        boolean b=c.moveToFirst();
        while(b==true){
            al.add(c.getString(1));
            b=c.moveToNext();
        }
        Ad=new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, al);
        actv_word.setAdapter(Ad);
        actv_word.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String word=adapterView.getItemAtPosition(i).toString();
                query="select meaning from dict where word='"+word+"'";
                c=db.rawQuery(query, null);
                if (c.moveToFirst()){
                    tv_meaning.setText(c.getString(0));
                }
            }
        });
    }
    public void addword(View view){
        Intent I=new Intent(MainActivity.this, loginactivity.class);
        startActivity(I);
        finish();
    }
}