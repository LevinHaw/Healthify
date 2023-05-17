package com.example.informatikakesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Salmonellosis extends AppCompatActivity {

    private TextView ref1, ref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salmonellosis);

        ref1 = findViewById(R.id.tv_refSalmonellosis);
        ref1.setMovementMethod(LinkMovementMethod.getInstance());

        ref2 = findViewById(R.id.tv_refSalmonellosis2);
        ref2.setMovementMethod(LinkMovementMethod.getInstance());

    }
}