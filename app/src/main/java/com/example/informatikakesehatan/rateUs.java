package com.example.informatikakesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class rateUs extends AppCompatActivity {

    Button button;
    RatingBar rateUs;

    float myRating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);

        button = findViewById(R.id.button);
        rateUs = findViewById(R.id.ratingBar);

        rateUs.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                int rating = (int) v;
                String message = null;
                myRating = ratingBar.getRating();

                switch (rating) {
                    case 0:
                        message = "Sorry to hear that";
                        break;
                    case 1:
                        message = "We apologize for the inconvenience";
                        break;
                    case 2:
                        message = "Sorry, we will try to improve for better";
                        break;
                    case 3:
                        message = "Good enough";
                        break;
                    case 4:
                        message = "Great, Thank you!";
                        break;
                    case 5:
                        message = "Thank you, we hope you can stay with us :) ";
                        break;
                }

                Toast.makeText(rateUs.this, message, Toast.LENGTH_SHORT).show();

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(rateUs.this, "Your rating is : " + myRating, Toast.LENGTH_SHORT).show();
            }
        });

    }
}