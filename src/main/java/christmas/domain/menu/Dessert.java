package christmas.domain.menu;

public enum Dessert implements Menu{

    초코케이크("초코케이크", 15000),
    아이스크림("아이스크림", 5000);

    private final int price;

    Dessert(String menuName, int price) {
        this.price = price;
    }

    @Override
    public int getPrice(String menuName) {
        return Dessert.valueOf(menuName).price;
    }
}
