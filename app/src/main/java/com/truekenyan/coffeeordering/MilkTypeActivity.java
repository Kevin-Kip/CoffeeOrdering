package com.truekenyan.coffeeordering;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_type);

        ButterKnife.bind(this);

        i = getIntent();
        if (i != null) {
            priceWithMilk = i.getIntExtra("price", priceWithMilk);
        }
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
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        i.removeExtra("price");
    }
}
