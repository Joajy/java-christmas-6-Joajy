package christmas.domain;

import christmas.domain.menu.*;

import static christmas.util.InputConstant.*;

public class Order {

    private final String menuName;
    private final Menu category;
    private final int orderAmount;

    private static final String REGEX = "^[0-9]+$";

    private static final int MAX_MENU_COUNT = 20;
    private static final int MIN_MENU_COUNT = 1;

    public Order(String menuName, String orderAmount) {
        this.menuName = menuName;
        this.category = validateCategory(menuName);
        this.orderAmount = validateOrderAmount(orderAmount);
    }

    public Menu getCategory(){
        return category;
    }

    public int validateOrderAmount(String orderAmount){
        validateOrderAmountType(orderAmount);
        int amount = Integer.parseInt(orderAmount);
        if (amount > MAX_MENU_COUNT || amount < MIN_MENU_COUNT) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
        return amount;
    }

    public void validateOrderAmountType(String orderAmount) {
        if(!orderAmount.matches(REGEX)){
            throw new NumberFormatException(INVALID_ORDER);
        }
    }

    public Menu validateCategory(String menuName) {
        if (MenuList.DESSERT.contains(menuName)) {
            return Dessert.valueOf(menuName);
        }
        if (MenuList.MAIN.contains(menuName)) {
            return Main.valueOf(menuName);
        }
        if (MenuList.APPETIZER.contains(menuName)) {
            return Appetizer.valueOf(menuName);
        }
        if (MenuList.BEVERAGE.contains(menuName)) {
            return Beverage.valueOf(menuName);
        }
        throw new IllegalArgumentException(INVALID_ORDER);
    }

    public String getMenuName(){
        return menuName;
    }

    public int getOrderAmount() {
        return orderAmount;
    }
}
