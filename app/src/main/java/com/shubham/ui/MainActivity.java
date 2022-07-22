package com.shubham.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView username ;
    private TextView fullName ;
    private TextView email ;
    private TextView password ;
    private Button signUP;
    private CheckBox terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username= findViewById(R.id.username);
        fullName= findViewById(R.id.fullName);
        email= findViewById(R.id.email);
        password= findViewById(R.id.password);

        signUP = findViewById(R.id.signUp);
        terms = findViewById(R.id.checkbox_terms_and_conditions);

        signUP.setOnClickListener(v -> {

            if (allFields()){
                if (terms.isChecked()){
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                    intent.putExtra("Username", username.getText().toString().trim() );
                    startActivity(intent);

                }else{
                    Toast.makeText(MainActivity.this, "Please Accept the Terms and Conditions.", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(MainActivity.this, "Please Enter All the Fields", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private boolean allFields() {
        return !username.getText().toString().trim().equals("") &&
                !fullName.getText().toString().trim().equals("") &&
                !email.getText().toString().trim().equals("") &&
                !password.getText().toString().trim().equals("");
    }
}