package christmas.domain.menu;

public enum Dessert implements Menu{

    초코케이크("초코케이크", 15000, 0),
    아이스크림("아이스크림", 5000, 0);

    private final String menuName;
    private final int price;
    private final int order;

    Dessert(String menuName, int price, int order) {
        this.menuName = menuName;
        this.price = price;
        this.order = order;
    }

    @Override
    public int getPrice(String menuName) {
        return Dessert.valueOf(menuName).price;
    }
}
