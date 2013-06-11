package net.hyang.howmuchtips;

import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hyang on 6/7/13.
 */
public class TipAmountCalculator implements NumberPicker.OnValueChangeListener {
    private List<NumberPicker> bill;
    private List<NumberPicker> tipsPercentage;
    private TextView amountView;

    public TipAmountCalculator(List<NumberPicker> bill, List<NumberPicker> tipsPercentage, TextView amountView) {
        this.bill = bill;
        this.tipsPercentage = tipsPercentage;
        this.amountView = amountView;
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i2) {
        StringBuilder billString = new StringBuilder();
        StringBuilder tipsPercentageString = new StringBuilder();

        for (NumberPicker np : bill) {
            billString.append(np.getValue());
        }
        for (NumberPicker np : tipsPercentage) {
            tipsPercentageString.append(np.getValue());
        }
        float billAmount = Float.parseFloat(billString.toString());
        billAmount = billAmount / 100f;
        float tipsPercentage = Float.parseFloat(tipsPercentageString.toString());
        tipsPercentage = tipsPercentage / 10000f;

//        amountView.setText(String.valueOf());
        amountView.setText(String.format("%.2f", billAmount*tipsPercentage));

    }
}
