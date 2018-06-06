package com.truekenyan.coffeeordering;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MilkTypeActivity extends AppCompatActivity {

    @BindView(R.id.item_cow)
    TextView itemCow;
    @BindView(R.id.item_soy)
    TextView itemSoy;
    @BindView(R.id.item_rice)
    TextView itemRice;
    @BindView(R.id.item_coconut)
    AppCompatTextView itemCoconut;

    private int priceWithMilk = 0;

    private Intent i;

    Animation milkCow;
    Animation milkSoy;
    Animation milkRice;
    Animation milkCoconut;

    Drawable[] iconCow;
    Drawable[] iconSoy;
    Drawable[] iconRice;
    Drawable[] iconCoconut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_type);

        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1) {
            iconCow = itemCow.getCompoundDrawables();
            iconSoy = itemSoy.getCompoundDrawables();
            iconRice = itemRice.getCompoundDrawables();
            iconCoconut = itemCoconut.getCompoundDrawables();

            iconCow[0].setColorFilter(getResources().getColor(R.color.colorGoldText), PorterDuff.Mode.MULTIPLY);
            iconSoy[0].setColorFilter(getResources().getColor(R.color.colorGoldText), PorterDuff.Mode.MULTIPLY);
            iconRice[0].setColorFilter(getResources().getColor(R.color.colorGoldText), PorterDuff.Mode.MULTIPLY);
            iconCoconut[0].setColorFilter(getResources().getColor(R.color.colorGoldText), PorterDuff.Mode.MULTIPLY);
        }

        i = getIntent();
        if (i != null) {
            priceWithMilk = i.getIntExtra("price", priceWithMilk);
        }

        milkCow = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.milk_reveal_cow);
        milkSoy = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.milk_reveal_soy);
        milkRice = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.milk_reveal_rice);
        milkCoconut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.milk_reveal_coconut);

        itemCow.setAnimation(milkCow);
        itemSoy.setAnimation(milkSoy);
        itemRice.setAnimation(milkRice);
        itemCoconut.setAnimation(milkCoconut);
    }

    @OnClick({R.id.item_cow, R.id.item_soy, R.id.item_rice, R.id.item_coconut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.item_cow:
                priceWithMilk += 1;
                startNextActivity(priceWithMilk);
                break;
            case R.id.item_soy:
                priceWithMilk += 2;
                startNextActivity(priceWithMilk);
                break;
            case R.id.item_rice:
                priceWithMilk += 3;
                startNextActivity(priceWithMilk);
                break;
            case R.id.item_coconut:
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
