package com.truekenyan.coffeeordering;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderSummaryActivity extends AppCompatActivity {

    @BindView(R.id.total_price)
    TextView totalPrice;
    @BindView(R.id.button_again)
    Button buttonAgain;
    @BindView(R.id.time)
    TextView time;

    private Intent intent;

    private int finalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        ButterKnife.bind(this);

        intent = getIntent();
        if (intent != null) {
            finalPrice = intent.getIntExtra("price", finalPrice);
        }

        totalPrice.setText(String.format("%s %s %s", getString(R.string.total), getString(R.string.dollar), String.valueOf(finalPrice)));

        time.setText(getString(R.string.your_order));
    }

    @OnClick(R.id.button_again)
    public void onViewClicked() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
//        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        intent.removeExtra("price");
    }
}
