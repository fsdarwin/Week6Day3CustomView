package com.example.week6day3customview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.week6day3customview.view.CompoundView;
import com.example.week6day3customview.view.CustomEditText;
import com.example.week6day3customview.view.CustomView;

public class MainActivity extends AppCompatActivity {

    CompoundView compoundView;
    int counter = 0;
    TextView vTvCounter;
    CustomEditText customEditText;
    CustomView vTvRect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compoundView = findViewById(R.id.compound);
        vTvCounter = findViewById(R.id.tvCounter);

        vTvRect = findViewById(R.id.Rect);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),

                        R.anim.animation);

        vTvRect.startAnimation(animation1);

        customEditText = findViewById(R.id.etColorEdit);
        customEditText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                customEditText.checkColor();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                customEditText.checkColor();
            }

            @Override
            public void afterTextChanged(Editable s) {
                customEditText.checkColor();
            }
        });
    }

    public void onClick(View view) {
        counter++;
        vTvCounter.setText(counter + "");
    }
}
