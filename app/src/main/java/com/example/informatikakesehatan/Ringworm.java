package com.example.informatikakesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Ringworm extends AppCompatActivity {

    private TextView ref1, ref2, ref3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringworm);

        ref1 = findViewById(R.id.tv_refRingworm);
        ref1.setMovementMethod(LinkMovementMethod.getInstance());

        ref2 = findViewById(R.id.tv_refRingworm2);
        ref2.setMovementMethod(LinkMovementMethod.getInstance());

        ref3 = findViewById(R.id.tv_refRingworm3);
        ref3.setMovementMethod(LinkMovementMethod.getInstance());

    }
}