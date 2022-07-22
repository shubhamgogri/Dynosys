package com.shubham.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;

public class MainActivity2 extends AppCompatActivity {

    private TextView title;
    private Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        title = findViewById(R.id.title_main);
        logOut = findViewById(R.id.logout);

        Intent intent = getIntent();
        String username = intent.getStringExtra("Username");

        title.setText(MessageFormat.format("Hi, {0} \n Tell About Yourself.", username));

        logOut.setOnClickListener(v -> {
            Toast.makeText(MainActivity2.this, "Logged Out", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(MainActivity2.this, MainActivity.class);

            startActivity(intent1);
        });

    }
}