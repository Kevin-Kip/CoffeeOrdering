package com.truekenyan.coffeeordering;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.florent37.androidslidr.Slidr;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FoamActivity extends AppCompatActivity {

    @BindView(R.id.mug)
    ImageView mug;
    @BindView(R.id.foam_level)
    private TextView foamLevel;
    @BindView(R.id.foam_level_adjust)
    private Slidr foamLevelAdjust;
    @BindView(R.id.button_next)
    Button buttonNext;

    private int currentPrice = 0;
    private float selectedValue = 5F;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foam);

        ButterKnife.bind(this);

        intent = getIntent();
        if (intent != null){
            currentPrice = intent.getIntExtra("price", currentPrice);
        }

        foamLevelAdjust.setCurrentValue(5F);
        foamLevelAdjust.setMax(100F);
        foamLevelAdjust.setMin(0F);
        foamLevel.setText(String.format("%s%s",String.valueOf((int)foamLevelAdjust.getCurrentValue()), getString(R.string.percent)));
        foamLevelAdjust.setListener(new Slidr.Listener() {
            @Override
            public void valueChanged(Slidr slidr, float currentValue) {
                selectedValue = (int) currentValue;
                foamLevel.setText(String.format("%s%s",String.valueOf((int)selectedValue), getString(R.string.percent)));
            }

            @Override
            public void bubbleClicked(Slidr slidr) {

            }
        });
    }

    @OnClick(R.id.button_next)
    public void onViewClicked() {
        Intent i = new Intent(getApplicationContext(), OrderSummaryActivity.class);
        i.putExtra("price", getCurrentPrice());
        startActivity(i);
//        finish();
    }

    private int getCurrentPrice(){
        return currentPrice + (currentPrice * (int)(selectedValue/100));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        intent.removeExtra("price");
    }
}
