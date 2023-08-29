package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Activity2 extends AppCompatActivity {
Button btn2;
TextView number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        btn2 = findViewById(R.id.btn2);
        number = findViewById(R.id.textView3);

        //Getting data from main activity
        Intent i = getIntent();
        String inputName = i.getStringExtra("name");

        //Random Number Generation
        int randomNum = generateRandomNumber();
        number.setText("" + randomNum);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(inputName,randomNum);
            }
        });
    }

    public int generateRandomNumber(){
        Random random = new Random();
        int upperLimit = 100;

        int generatedNumber = random.nextInt(upperLimit);
        return generatedNumber;
    }

    public void shareData(String inputName, int randomNum){
        //Implicit intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT, inputName+ " got lucky today");
        i.putExtra(Intent.EXTRA_TEXT, "His Lucky Number is "+ randomNum);

        startActivity(Intent.createChooser(i,"Share via"));
    }
}