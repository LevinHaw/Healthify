package com.example.informatikakesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Diarrhea extends AppCompatActivity {

    private TextView ref1, ref2, ref3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diarrhea);

        ref1 = findViewById(R.id.tv_refdi1);
        ref1.setMovementMethod(LinkMovementMethod.getInstance());

        ref2 = findViewById(R.id.tv_refdi2);
        ref2.setMovementMethod(LinkMovementMethod.getInstance());

        ref3 = findViewById(R.id.tv_refdi3);
        ref3.setMovementMethod(LinkMovementMethod.getInstance());

    }
}