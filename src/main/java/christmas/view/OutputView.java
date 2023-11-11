package christmas.view;

import christmas.domain.Order;
import christmas.service.OrderService;

import java.text.DecimalFormat;
import java.util.List;

import static christmas.util.OutputConstant.*;

public class OutputView {

    public static String splitMoneyView(int money){
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(money);
    }

    public static void printBaseStatus(List<Order> orders) {
        printMenu(orders);
        printBeforeDiscount(orders);
    }

    public static void printMenu(List<Order> orders) {
        System.out.println(ORDER_MENU);
        for (Order order : orders) {
            System.out.println(order.getMenuName() + " " + order.getOrderAmount() + "개");
        }
        System.out.println();
    }

    public static void printBeforeDiscount(List<Order> orders) {
        System.out.println(BEFORE_DISCOUNT);
        int money = OrderService.totalOrderAmount(orders);
        System.out.println(splitMoneyView(money) + PRICE_UNIT + "\n");
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
