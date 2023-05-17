package com.example.informatikakesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Asthma extends AppCompatActivity {

    TextView ref1, ref2, ref3, ref4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asthma);

        ref1 = findViewById(R.id.tv_ref1);
        ref1.setMovementMethod(LinkMovementMethod.getInstance());

        ref2 = findViewById(R.id.tv_ref2);
        ref2.setMovementMethod(LinkMovementMethod.getInstance());

        ref3 = findViewById(R.id.tv_ref3);
        ref3.setMovementMethod(LinkMovementMethod.getInstance());

        ref4 = findViewById(R.id.tv_ref4);
        ref4.setMovementMethod(LinkMovementMethod.getInstance());

    }
}