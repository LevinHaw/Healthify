package com.example.informatikakesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Constipation extends AppCompatActivity {

    private TextView ref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constipation);

        ref1 = findViewById(R.id.tv_refConstipation);
        ref1.setMovementMethod(LinkMovementMethod.getInstance());

    }
}