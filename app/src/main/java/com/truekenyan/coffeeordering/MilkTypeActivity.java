package com.truekenyan.coffeeordering;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MilkTypeActivity extends AppCompatActivity {

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.parent_cow)
    LinearLayout parentCow;
    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.parent_soy)
    LinearLayout parentSoy;
    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.parent_rice)
    LinearLayout parentRice;
    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.parent_coconut)
    LinearLayout parentCoconut;

    private int priceWithMilk = 0;

    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_type);

        ButterKnife.bind(this);

        i = getIntent();
        if (i != null) {
            priceWithMilk = i.getIntExtra("price", priceWithMilk);
        }

        Animation milkCow = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.milk_reveal_cow);
        Animation milkSoy = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.milk_reveal_soy);
        Animation milkRice = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.milk_reveal_rice);
        Animation milkCoconut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.milk_reveal_coconut);

        parentCow.setAnimation(milkCow);
        parentSoy.setAnimation(milkSoy);
        parentRice.setAnimation(milkRice);
        parentCoconut.setAnimation(milkCoconut);
    }

    @OnClick({R.id.parent_cow, R.id.parent_soy, R.id.parent_rice, R.id.parent_coconut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.parent_cow:
                priceWithMilk += 1;
                startNextActivity(priceWithMilk);
                break;
            case R.id.parent_soy:
                priceWithMilk += 2;
                startNextActivity(priceWithMilk);
                break;
            case R.id.parent_rice:
                priceWithMilk += 3;
                startNextActivity(priceWithMilk);
                break;
            case R.id.parent_coconut:
                priceWithMilk += 4;
                startNextActivity(priceWithMilk);
                break;
        }
    }

    private void startNextActivity(int price) {
        Intent intent = new Intent(getApplicationContext(), MilkBalanceActivity.class);
        intent.putExtra("price", price);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        i.removeExtra("price");
    }
}
