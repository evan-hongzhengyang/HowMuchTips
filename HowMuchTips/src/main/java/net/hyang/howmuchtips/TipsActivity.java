package net.hyang.howmuchtips;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TipsActivity extends Activity {
    private List<NumberPicker> billAmount;
    private List<NumberPicker> tipPercentage;

    private TipAmountCalculator mTipAmountCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tips_main);
        initBill();
        initTipPercentage();

        showRealTimeTips();
    }

    private void initBill() {
        this.billAmount = new ArrayList<NumberPicker>();
        NumberPicker billNumberHundreds = (NumberPicker) this.findViewById(R.id.bill_hundreds);
        NumberPicker billNumberTens = (NumberPicker) this.findViewById(R.id.bill_tens);
        NumberPicker billNumberUnits = (NumberPicker) this.findViewById(R.id.bill_units);
        NumberPicker billNumberDecimalOne = (NumberPicker) this.findViewById(R.id.bill_decimal_one);
        NumberPicker billNumberDecimalTwo = (NumberPicker) this.findViewById(R.id.bill_decimal_two);

        billAmount.add(billNumberHundreds);
        billAmount.add(billNumberTens);
        billAmount.add(billNumberUnits);
        billAmount.add(billNumberDecimalOne);
        billAmount.add(billNumberDecimalTwo);

        initNumberRange(billAmount);


    }

    private void initNumberRange(List<NumberPicker> np) {
        for (NumberPicker numberPicker : np) {
            numberPicker.setMinValue(0);
            numberPicker.setMaxValue(9);
        }
    }

    private void initTipPercentage() {
        this.tipPercentage = new ArrayList<NumberPicker>();
        NumberPicker tipPercentageTens = (NumberPicker) this.findViewById(R.id.tip_percentage_tens);
        NumberPicker tipPercentageUnits = (NumberPicker) this.findViewById(R.id.tip_percentage_units);
        NumberPicker tipPercentageDecimalOne = (NumberPicker) this.findViewById(R.id.tip_percentage_decimal_one);
        NumberPicker tipPercentageDecimalTwo = (NumberPicker) this.findViewById(R.id.tip_percentage_decimal_two);

        tipPercentage.add(tipPercentageTens);
        tipPercentage.add(tipPercentageUnits);
        tipPercentage.add(tipPercentageDecimalOne);
        tipPercentage.add(tipPercentageDecimalTwo);

        initNumberRange(tipPercentage);

        tipPercentageTens.setValue(1);
        tipPercentageUnits.setValue(5);
    }

    private void showRealTimeTips() {
        for (NumberPicker np : billAmount) {
            np.setOnValueChangedListener(
                    new TipAmountCalculator(billAmount, tipPercentage,(TextView) this.findViewById(R.id.tipsAmount)));
        }
        for (NumberPicker np : tipPercentage) {
            np.setOnValueChangedListener(
                    new TipAmountCalculator(billAmount, tipPercentage,(TextView) this.findViewById(R.id.tipsAmount)));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tips, menu);
        return true;
    }
    
}
