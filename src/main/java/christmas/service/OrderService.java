package christmas.service;

import christmas.domain.Order;
import christmas.domain.discount.ChristmasDDayDiscount;
import christmas.domain.discount.SpecialDiscount;
import christmas.domain.discount.WeekdayDiscount;
import christmas.domain.discount.WeekendDiscount;
import christmas.domain.menu.MenuList;

import java.util.List;

public class OrderService {

    private static final String AMOUNT_DELIMITER = "-";

    private static List<Order> orders;
    private static int day;
    private static SpecialDiscount specialDiscount = new SpecialDiscount();
    private static WeekdayDiscount weekdayDiscount = new WeekdayDiscount();
    private static ChristmasDDayDiscount christmasDDayDiscount = new ChristmasDDayDiscount();
    private static WeekendDiscount weekendDiscount = new WeekendDiscount();

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
}
