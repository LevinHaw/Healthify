package com.example.informatikakesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Measles extends AppCompatActivity {

    private TextView ref1, ref2, ref3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measles);

        ref1 = findViewById(R.id.tv_refMeasles);
        ref1.setMovementMethod(LinkMovementMethod.getInstance());

        ref2 = findViewById(R.id.tv_refMeasles2);
        ref2.setMovementMethod(LinkMovementMethod.getInstance());

        ref3 = findViewById(R.id.tv_refMeasles2);
        ref3.setMovementMethod(LinkMovementMethod.getInstance());

    }
}