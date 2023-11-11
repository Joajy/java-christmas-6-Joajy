package christmas.domain;

import christmas.domain.menu.*;

import static christmas.util.InputConstant.*;

public class Order {

    private final String menuName;
    private final Menu category;
    private final int orderAmount;

    public Order(String menuName, int orderAmount) {
        this.menuName = menuName;
        this.category = validateCategory(menuName);
        this.orderAmount = orderAmount;
        validateOrderAmount(orderAmount);
    }

    public Menu getCategory(){
        return category;
    }

    public void validateOrderAmount(int orderAmount){
        if (orderAmount > 20 || orderAmount < 1) {
            throw new IllegalArgumentException(INVALID_ORDER);
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
