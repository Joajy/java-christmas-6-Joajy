package christmas.view;

import christmas.domain.Order;

import java.text.DecimalFormat;
import java.util.List;

import static christmas.util.OutputConstant.*;

public class OutputView {

    public static String splitMoneyView(int money){
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(money);
    }

    public static void printBaseStatus(List<Order> orders, int money) {
        printMenu(orders);
        printBeforeDiscount(money);
    }

    public static void printBenefits(List<Integer> benefits, int money){
        printFreeMenu(money);
        printBenefitsHistory(benefits, money);
        int discount = -printTotalBenefits(benefits, money);
        printPayAfterBenefit(money, discount);
        printEventBadge(discount);
    }

    public static void printEventBadge(int discount) {
        System.out.println(EVENT_BADGE);
        if (discount >= VVIP_PRICE) {
            System.out.println(VVIP_BADGE);
            return;
        }
        if (discount >= VIP_PRICE) {
            System.out.println(VIP_BADGE);
            return;
        }
        if (discount >= NORMAL_PRICE) {
            System.out.println(NORMAL_BADGE);
            return;
        }
        System.out.println(NOTHING);
    }

    public static void printPayAfterBenefit(int money, int discount) {
        System.out.println(AFTER_DISCOUNT);
        if(money >= FREEBIE_MINIMUM_PRICE) {
            discount -= CHAMPAGNE_PRICE;
        }
        System.out.println(splitMoneyView(money - discount) + PRICE_UNIT + "\n");
    }

    public static int printTotalBenefits(List<Integer> discounts, int money){
        System.out.println(DISCOUNT_BENEFIT);
        int totalBenefits = 0;
        for (int discount : discounts) {
            totalBenefits += discount;
        }
        if(money >= FREEBIE_MINIMUM_PRICE) {
            totalBenefits -= CHAMPAGNE_PRICE;
        }
        System.out.println(splitMoneyView(totalBenefits) + PRICE_UNIT + "\n");
        return totalBenefits;
    }

    public static void printMenu(List<Order> orders) {
        System.out.println(ORDER_MENU);
        for (Order order : orders) {
            System.out.println(order.getMenuName() + " " + order.getOrderAmount() + "개");
        }
        System.out.println();
    }

    public static void printBeforeDiscount(int money) {
        System.out.println(BEFORE_DISCOUNT);
        System.out.println(splitMoneyView(money) + PRICE_UNIT + "\n");
    }

    public static void printFreeMenu(int money){
        System.out.println(FREE_MENU);
        if(money >= FREEBIE_MINIMUM_PRICE){
            System.out.println(FREE_GIFT);
            return;
        }
        System.out.println(NOTHING + "\n");
    }

    public static void printBenefitsHistory(List<Integer> discounts, int money) {
        System.out.println(BENEFITS_HISTORY);
        printBenefit(discounts, money);
        int noBenefits = 0;
        for (int discount : discounts) {
            noBenefits += nothingDiscount(discount);
        }
        if(noBenefits == discounts.size() && money < FREEBIE_MINIMUM_PRICE){
            System.out.println(NOTHING + "\n");
        }
    }

    public static void printBenefit(List<Integer> discounts, int money) {
        printChristmasBenefit(discounts.get(0));
        printSpecialBenefit(discounts.get(1));
        printWeekdayBenefit(discounts.get(2));
        printWeekendBenefit(discounts.get(3));
        printFreebieBenefit(money);
    }

    public static int nothingDiscount(int discount){
        if(discount == 0){
            return 1;
        }
        return 0;
    }

    public static void printChristmasBenefit(int money){
        if(money == 0) return;
        System.out.println(CHRISTMAS_BENEFIT + splitMoneyView(money) + PRICE_UNIT);
    }

    public static void printWeekdayBenefit(int money) {
        if(money == 0) return;
        System.out.println(WEEKDAY_BENEFIT + splitMoneyView(money) + PRICE_UNIT);
    }

    public static void printWeekendBenefit(int money) {
        if(money == 0) return;
        System.out.println(WEEKEND_BENEFIT + splitMoneyView(money) + PRICE_UNIT);
    }

    public static void printSpecialBenefit(int money) {
        if(money == 0) return;
        System.out.println(SPECIAL_BENEFIT + splitMoneyView(money) + PRICE_UNIT);
    }

    public static void printFreebieBenefit(int money) {
        if(money >= FREEBIE_MINIMUM_PRICE){
            System.out.println(FREEBIE_BENEFIT);
        }
    }

}
