package com.truekenyan.coffeeordering;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.coffee_small)
    LinearLayout smallCoffee;
    @BindView(R.id.coffee_medium)
    LinearLayout mediumCoffee;
    @BindView(R.id.coffee_large)
    LinearLayout largeCoffee;
    @BindView(R.id.coffee_extra_large)
    LinearLayout extraLargeCoffee;

    Animation smallAnimation;
    Animation mediumAnimation;
    Animation largeAnimation;
    Animation extraLargeAnimation;

    int cupSizePrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        smallAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.coffee_reveal_small);
        mediumAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.coffee_reveal_medium);
        largeAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.coffee_reveal_large);
        extraLargeAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.coffee_reveal_extra_large);

        smallCoffee.setAnimation(smallAnimation);
        mediumCoffee.setAnimation(mediumAnimation);
        largeCoffee.setAnimation(largeAnimation);
        extraLargeCoffee.setAnimation(extraLargeAnimation);
    }

    @OnClick({R.id.coffee_small, R.id.coffee_medium, R.id.coffee_large, R.id.coffee_extra_large})
    public void onViewClicked(View v) {
        int id = v.getId();
        switch (id){
            case R.id.coffee_small:
                cupSizePrice = 5;
                startNextActivity(cupSizePrice);
                break;
            case R.id.coffee_medium:
                cupSizePrice = 10;
                startNextActivity(cupSizePrice);
                break;
            case R.id.coffee_large:
                cupSizePrice = 15;
                startNextActivity(cupSizePrice);
                break;
            case R.id.coffee_extra_large:
                cupSizePrice = 20;
                startNextActivity(cupSizePrice);
                break;
            default:
                break;
        }
    }

    private void startNextActivity(int price){
        Intent intent = new Intent(getApplicationContext(), MilkTypeActivity.class);
        intent.putExtra("price", price);
        startActivity(intent);
    }
}
