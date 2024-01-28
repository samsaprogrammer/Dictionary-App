package com.example.dictinary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class loginactivity extends AppCompatActivity {

    EditText et_userid, et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        et_userid=findViewById(R.id.et_userid);
        et_password=findViewById(R.id.et_password);
    }
    public void login(View view){
        if (et_userid.getText().toString().isEmpty()){
            et_userid.setError("Empty");
            et_userid.requestFocus();
        }else {
            if (et_password.getText().toString().isEmpty()){
                et_password.setError("Empty");
                et_password.requestFocus();
            }else {
                // Here we Write for login............
                String userid=et_userid.getText().toString();
                String passwrod=et_password.getText().toString();
                if (userid.equals("admin") && passwrod.equals("admin@123")){
                    Toast.makeText(this, "Valid User", Toast.LENGTH_SHORT).show();
                    Intent I=new Intent(loginactivity.this, AddWordActivity.class);
                    startActivity(I);
                    finish();
                }else {
                    Toast.makeText(this, "Invalid User", Toast.LENGTH_SHORT).show();
                    et_userid.setText("");
                    et_password.setText("");
                }
            }
        }
    }
}