package christmas.view;

import java.text.DecimalFormat;
import java.util.List;

import static christmas.util.OutputConstant.*;

public class OutputView {

    public static String splitMoneyView(int money){
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(money);
    }

    public static void printBenefit(List<Integer> discounts, int money) {
        printChristmasBenefit(discounts.get(0));
        printSpecialBenefit(discounts.get(1));
        printWeekdayBenefit(discounts.get(2));
        printWeekendBenefit(discounts.get(3));
        printFreebieBenefit(money);
    }

    public static void printChristmasBenefit(int money){
        if(money == 0) return;
        System.out.println(CHRISTMAS_BENEFIT + "-" + splitMoneyView(money) + PRICE_UNIT);
    }

    public static void printWeekdayBenefit(int money) {
        if(money == 0) return;
        System.out.println(WEEKDAY_BENEFIT + "-" + splitMoneyView(money) + PRICE_UNIT);
    }

    public static void printWeekendBenefit(int money) {
        if(money == 0) return;
        System.out.println(WEEKEND_BENEFIT + "-" + splitMoneyView(money) + PRICE_UNIT);
    }

    public static void printSpecialBenefit(int money) {
        if(money == 0) return;
        System.out.println(SPECIAL_BENEFIT + "-"  + splitMoneyView(money) + PRICE_UNIT);
    }

    public static void printFreebieBenefit(int money) {
        if(money >= 120000){
            System.out.println(FREEBIE_BENEFIT);
        }
    }

}
