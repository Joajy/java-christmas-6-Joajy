package christmas.domain.menu;

public enum Appetizer implements Menu{
    양송이수프("양송이수프", 6000, 0),
    타파스("타파스", 5500, 0),
    시저샐러드("시저샐러드", 8000, 0);

    private final String menuName;
    private final int price;
    private final int order;

    Appetizer(String menuName, int price, int order) {
        this.menuName = menuName;
        this.price = price;
        this.order = order;
    }

    @Override
    public int getPrice(String menuName) {
        return Appetizer.valueOf(menuName).price;
    }
}
