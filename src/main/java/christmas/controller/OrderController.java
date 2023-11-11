package christmas.controller;

import christmas.domain.Order;

import java.util.List;

import static christmas.view.InputView.*;

public class OrderController {

    public static void play(){
        introduction();
        List<Order> orders = order();
        int money = totalOrderAmount(orders);
        printBaseStatus(orders);
        printBenefits(benefits(orders), money);
    }
}
