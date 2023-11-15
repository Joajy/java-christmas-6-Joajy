package christmas.domain.menu;

public enum Beverage implements Menu{

    제로콜라("제로콜라", 3000),
    레드와인("레드와인", 60000),
    샴페인("샴페인", 25000);

    private final int price;

    Beverage(String menuName, int price) {
        this.price = price;
    }

    @Override
    public int getPrice(String menuName) {
        return Beverage.valueOf(menuName).price;
    }
}
