package christmas.view;

import java.text.DecimalFormat;

public class OutputView {

    public static String splitMoneyView(int money){
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(money);
    }
}
