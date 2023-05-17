package com.example.informatikakesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Head_lice extends AppCompatActivity {

    private TextView ref1, ref2, ref3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_lice);

        ref1 = findViewById(R.id.tv_refHead);
        ref1.setMovementMethod(LinkMovementMethod.getInstance());

        ref2 = findViewById(R.id.tv_refHead2);
        ref2.setMovementMethod(LinkMovementMethod.getInstance());

        ref3 = findViewById(R.id.tv_refHead3);
        ref3.setMovementMethod(LinkMovementMethod.getInstance());

    }
}