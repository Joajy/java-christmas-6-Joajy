package christmas.domain.menu;

public enum Beverage implements Menu{

    제로콜라("제로콜라", 3000, 0),
    레드와인("레드와인", 60000, 0),
    샴페인("샴페인", 25000, 0);

    private final String menuName;
    private final int price;
    private final int order;

    Beverage(String menuName, int price, int order) {
        this.menuName = menuName;
        this.price = price;
        this.order = order;
    }

    @Override
    public int getPrice(String menuName) {
        return Beverage.valueOf(menuName).price;
    }
}
