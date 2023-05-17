package com.example.informatikakesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Osteoporosis extends AppCompatActivity {

    private TextView ref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_osteoporosis);

        ref1 = findViewById(R.id.tv_refOsteo);
        ref1.setMovementMethod(LinkMovementMethod.getInstance());


    }
}