package com.example.informatikakesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Diabetes_mellitus extends AppCompatActivity {

    private TextView ref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetes_mellitus);

        ref1 = findViewById(R.id.tv_refDiab);
        ref1.setMovementMethod(LinkMovementMethod.getInstance());

    }
}