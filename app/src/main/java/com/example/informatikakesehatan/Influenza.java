package com.example.informatikakesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Influenza extends AppCompatActivity {

    private TextView ref1, ref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_influenza);

        ref1 = findViewById(R.id.tv_refi1);
        ref1.setMovementMethod(LinkMovementMethod.getInstance());

        ref2 = findViewById(R.id.tv_refi2);
        ref2.setMovementMethod(LinkMovementMethod.getInstance());

    }
}