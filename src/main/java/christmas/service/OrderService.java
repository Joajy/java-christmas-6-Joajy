package christmas.service;

import christmas.domain.Order;
import christmas.domain.discount.ChristmasDDayDiscount;
import christmas.domain.discount.SpecialDiscount;
import christmas.domain.discount.WeekdayDiscount;
import christmas.domain.discount.WeekendDiscount;
import christmas.domain.menu.MenuList;
import christmas.util.InputConstant;

import java.util.ArrayList;
import java.util.List;

import static christmas.util.OutputConstant.CHAMPAGNE_PRICE;
import static christmas.util.OutputConstant.FREEBIE_MINIMUM_PRICE;
import static christmas.validator.OrdersValidator.*;
import static christmas.view.InputView.*;
import static christmas.view.OutputView.*;
import static java.util.Collections.*;

public class OrderService {

    private static final String AMOUNT_DELIMITER = "-";
    private static final int MINIMUM_PRICE_TO_EVENT = 10000;

    private static List<Order> orders;
    private static int day;

    private static final SpecialDiscount specialDiscount = new SpecialDiscount();
    private static final WeekdayDiscount weekdayDiscount = new WeekdayDiscount();
    private static final ChristmasDDayDiscount christmasDDayDiscount = new ChristmasDDayDiscount();
    private static final WeekendDiscount weekendDiscount = new WeekendDiscount();

    public static List<Order> order() {
        day = readDate();
        allOfOrderStatus();
        printEventBenefits(day);
        return orders;
    }

    public static void allOfOrderStatus(){
        try {
            String[] order = orderMenuWithAmount();
            orders = separateOrders(order);
        } catch (IllegalArgumentException e) {
            System.out.println(InputConstant.INVALID_ORDER);
            allOfOrderStatus();
        }
    }

    public static void organizeTotalEvent(List<Order> orders, int money) {
        printBaseStatus(orders, money);
        List<Integer> benefits = benefits(orders);
        eventPossibleOverCertainPrice(benefits, money);
        printBenefits(benefits, money);
    }

    public static void eventPossibleOverCertainPrice(List<Integer> benefits, int money) {
        if(money >= MINIMUM_PRICE_TO_EVENT) return;
        fill(benefits, 0);
    }

    public static List<Integer> benefits(List<Order> orders) {
        List<Integer> discounts = new ArrayList<>();
        discounts.add(-christmasDiscount(day));
        discounts.add(-specialDiscount(day));
        discounts.add(-weekdayDiscount(orders));
        discounts.add(-weekendDiscount(orders));
        return discounts;
    }

    public static int weekdayDiscount(List<Order> orders) {
        int weekdayDiscount = 0;
        for (Order order : orders) {
            weekdayDiscount += weekdayDiscount(order, day);
        }
        return weekdayDiscount;
    }

    public static int weekendDiscount(List<Order> orders) {
        int weekendDiscount = 0;
        for (Order order : orders) {
            weekendDiscount += weekendDiscount(order, day);
        }
        return weekendDiscount;
    }

    public static List<Order> separateOrders(String[] input) {
        List<Order> orders = new ArrayList<>();

        for(String order : input) {
            int menuAmountSeparator = order.indexOf(AMOUNT_DELIMITER);
            validateOrderHasNotDelimiter(menuAmountSeparator);
            String menuName = order.substring(0, menuAmountSeparator);
            String orderAmount = order.substring(menuAmountSeparator + 1);
            orders.add(new Order(menuName, orderAmount));
        }
        validateOrdersStatus(orders);
        return orders;
    }

    public static int specialDiscount(int day){
        return specialDiscount.discount(day);
    }

    public static int weekdayDiscount(Order order, int day) {
        if(MenuList.DESSERT.contains(order.getMenuName())){
            return weekdayDiscount.discount(day) * order.getOrderAmount();
        }
        return 0;
    }

    public static int weekendDiscount(Order order, int day) {
        if(MenuList.MAIN.contains(order.getMenuName())){
            return weekendDiscount.discount(day) * order.getOrderAmount();
        }
        return 0;
    }

    public static int christmasDiscount(int day){
        return christmasDDayDiscount.discount(day);
    }

    public static int totalOrderAmount(List<Order> orders){
        int totalAmount = 0;
        for (Order order : orders) {
            totalAmount += order.menuTotalPrice();
        }
        return totalAmount;
    }

    public static int totalBenefits(List<Integer> discounts, int money) {
        int totalBenefits = 0;
        for (int discount : discounts) {
            totalBenefits += discount;
        }
        totalBenefits += canGetFreeChampagne(money);
        return totalBenefits;
    }

    public static int canGetFreeChampagne(int money) {
        if(money >= FREEBIE_MINIMUM_PRICE) {
            return -CHAMPAGNE_PRICE;
        }
        return 0;
    }

}
