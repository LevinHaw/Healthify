package com.example.informatikakesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Chicken_pox extends AppCompatActivity {

    private TextView ref1, ref2, ref3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken_pox);

        ref1 = findViewById(R.id.tv_refChickpox);
        ref1.setMovementMethod(LinkMovementMethod.getInstance());

        ref2 = findViewById(R.id.tv_refChickpox2);
        ref2.setMovementMethod(LinkMovementMethod.getInstance());

        ref3 = findViewById(R.id.tv_refChickpox3);
        ref3.setMovementMethod(LinkMovementMethod.getInstance());

    }
}