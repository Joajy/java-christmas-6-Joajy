package christmas.view;

import christmas.domain.Order;

import java.text.DecimalFormat;
import java.util.List;

import static christmas.domain.EventBadge.*;
import static christmas.service.OrderService.*;
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
        System.out.println(getEventBadge(discount));
    }

    public static void printPayAfterBenefit(int money, int discount) {
        System.out.println(AFTER_DISCOUNT);
        discount += canGetFreeChampagne(money);
        System.out.println(splitMoneyView(money - discount) + PRICE_UNIT + "\n");
    }

    public static int printTotalBenefits(List<Integer> discounts, int money){
        System.out.println(DISCOUNT_BENEFIT);
        int totalBenefits = totalBenefits(discounts, money);
        System.out.println(splitMoneyView(totalBenefits) + PRICE_UNIT + "\n");
        return totalBenefits;
    }

    public static void printMenu(List<Order> orders) {
        System.out.println(ORDER_MENU);

        for (Order order : orders) {
            System.out.println(order.getMenuName() + " " + order.getOrderAmount() + COUNT_ORDER);
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

        if(hasNoBenefits(discounts) && money < FREEBIE_MINIMUM_PRICE){
            System.out.println(NOTHING);
        }

        System.out.println();
    }

    public static boolean hasNoBenefits(List<Integer> discounts) {
        //모두 같은 값이며, 그 값이 0인 경우
        return discounts.stream().distinct().count() == 1 && discounts.get(0) == 0;
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
        if(money < FREEBIE_MINIMUM_PRICE) return;
        System.out.println(FREEBIE_BENEFIT + splitMoneyView(CHAMPAGNE_PRICE) + PRICE_UNIT);
    }

}
