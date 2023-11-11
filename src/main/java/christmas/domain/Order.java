package christmas.domain;

import christmas.domain.menu.*;

public class Order {

    private final String menuName;
    private final Menu category;
    private final int orderAmount;

    public Order(String menuName, int orderAmount) {
        this.category = initCategory(menuName);
        this.menuName = menuName;
        this.orderAmount = orderAmount;
    }

    public Menu getCategory(){
        return category;
    }

    public Menu initCategory(String menuName) {
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
        throw new IllegalArgumentException();
    }

    public String getMenuName(){
        return menuName;
    }

    public int getOrderAmount() {
        return orderAmount;
    }
}
