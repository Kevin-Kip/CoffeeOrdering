package com.truekenyan.coffeeordering;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.coffee_small)
    LinearLayout smallCoffee;
    LinearLayout mediumCoffee;
    LinearLayout largeCoffee;
    LinearLayout extraLargeCoffee;

    Animation smallAnimation;
    Animation mediumAnimation;
    Animation largeAnimation;
    Animation extraLargeAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

//        smallCoffee = findViewById(R.id.coffee_small);
        mediumCoffee = findViewById(R.id.coffee_medium);
        largeCoffee = findViewById(R.id.coffee_large);
        extraLargeCoffee = findViewById(R.id.coffee_extra_large);

        smallAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.coffee_reveal_small);
        mediumAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.coffee_reveal_medium);
        largeAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.coffee_reveal_large);
        extraLargeAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.coffee_reveal_extra_large);

        smallCoffee.setAnimation(smallAnimation);
        mediumCoffee.setAnimation(mediumAnimation);
        largeCoffee.setAnimation(largeAnimation);
        extraLargeCoffee.setAnimation(extraLargeAnimation);

        smallCoffee.setOnClickListener(this);
        mediumCoffee.setOnClickListener(this);
        largeCoffee.setOnClickListener(this);
        extraLargeCoffee.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){

        }
    }
}
