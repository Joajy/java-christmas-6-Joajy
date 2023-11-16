package christmas.validator;

import christmas.domain.Order;
import christmas.domain.menu.MenuList;

import java.util.HashSet;
import java.util.List;

public class OrdersValidator {

    private static final int MAX_MENU_COUNT = 20;
    private static final int MIN_MENU_COUNT = 1;

    public static void validateOrdersStatus(List<Order> orders) {
        validateOrdersCount(orders);
        validateOrdersOnlyBeverage(orders);
        validateDuplicateOrders(orders);
    }

    public static void validateDuplicateOrders(List<Order> orders) {
        HashSet<String> menuName = new HashSet<>();
        for (Order order : orders) {
            menuName.add(order.getMenuName());
        }
        if(menuName.size() != orders.size()){
            throw new IllegalArgumentException();
        }
    }

    public static void validateOrdersOnlyBeverage(List<Order> orders) {
        int orderBeverage = 0;
        for (Order order : orders) {
            orderBeverage += validateOrderIsBeverage(order);
        }
        if(orderBeverage == orders.size()){
            throw new IllegalArgumentException();
        }
    }

    public static int validateOrderIsBeverage(Order order) {
        if(MenuList.BEVERAGE.contains(order.getMenuName())) {
            return 1;
        }
        return 0;
    }

    public static void validateOrdersCount(List<Order> orders) {
        int orderCount = 0;
        for (Order order : orders) {
            orderCount += order.getOrderAmount();
        }
        if(orderCount > MAX_MENU_COUNT || orderCount < MIN_MENU_COUNT){
            throw new IllegalArgumentException();
        }
    }

    public static void validateEmptyInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateOrderHasNotDelimiter(int menuAmountSeparator) {
        if (menuAmountSeparator == -1) {
            throw new IllegalArgumentException();
        }
    }
}
