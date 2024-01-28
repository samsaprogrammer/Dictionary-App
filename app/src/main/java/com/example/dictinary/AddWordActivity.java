package com.example.dictinary;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddWordActivity extends AppCompatActivity {

    EditText et_word, et_meaning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
        et_word=findViewById(R.id.et_word);
        et_meaning=findViewById(R.id.et_meaning);
    }
    public void add(View view){
        if (et_word.getText().toString().isEmpty()){
            et_word.setError("Empty");
            et_word.requestFocus();
        }else {
            if (et_meaning.getText().toString().isEmpty()){
                et_meaning.setError("Empty");
                et_meaning.requestFocus();
            }else {
                String word=et_word.getText().toString();
                String meaning=et_meaning.getText().toString();
                DbManager dm=new DbManager(this);
                SQLiteDatabase db=dm.getReadableDatabase();
                String query="insert into dict values('"+word+"', '"+meaning+"')";
                db.execSQL(query);
                Toast.makeText(this, "Word and meaning is added", Toast.LENGTH_SHORT).show();
                et_word.setText("");
                et_meaning.setText("");
            }
        }
    }
}