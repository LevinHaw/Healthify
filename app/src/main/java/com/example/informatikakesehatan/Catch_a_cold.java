package com.example.informatikakesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Catch_a_cold extends AppCompatActivity {

    private TextView ref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catch_acold);

        ref1 = findViewById(R.id.tv_refC1);
        ref1.setMovementMethod(LinkMovementMethod.getInstance());

    }
}