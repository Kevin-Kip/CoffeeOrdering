package com.truekenyan.coffeeordering;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.github.florent37.androidslidr.Slidr;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MilkBalanceActivity extends AppCompatActivity {

    @BindView(R.id.milk_balance)
    private TextView milkBalance;
    @BindView(R.id.milk_balance_level)
    private Slidr milkBalanceLevel;
    @BindView(R.id.button_next)
    Button buttonNext;

    private Intent intent;

    private int currentPrice = 0;
    private float selectedValue = 25F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_balance);

        ButterKnife.bind(this);

        intent = getIntent();

        if (intent != null){
            currentPrice = intent.getIntExtra("price", currentPrice);
        }

        milkBalanceLevel.setMin(0F);
        milkBalanceLevel.setMax(100F);
        milkBalanceLevel.setCurrentValue(25F);
        milkBalance.setText(String.format("%s%s", String.valueOf((int)milkBalanceLevel.getCurrentValue()), getString(R.string.percent)));
        milkBalanceLevel.setListener(new Slidr.Listener() {
            @Override
            public void valueChanged(Slidr slidr, float currentValue) {
                milkBalance.setText(String.format("%s%s", String.valueOf((int)currentValue), getString(R.string.percent)));
                selectedValue = currentValue;
            }

            @Override
            public void bubbleClicked(Slidr slidr) {

            }
        });
    }

    @OnClick(R.id.button_next)
    public void onViewClicked() {
        Intent i = new Intent(getApplicationContext(), FoamActivity.class);
        i.putExtra("price", getCurrentPrice());
        startActivity(i);
//        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        intent.removeExtra("price");
    }

    private int getCurrentPrice(){
        return currentPrice + (currentPrice * (int)(selectedValue/100));
    }
}
