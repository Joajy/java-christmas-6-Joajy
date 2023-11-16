package christmas.domain.menu;

public enum Appetizer implements Menu{
    양송이수프("양송이수프", 6000),
    타파스("타파스", 5500),
    시저샐러드("시저샐러드", 8000);

    private final int price;

    Appetizer(String menuName, int price) {
        this.price = price;
    }

    @Override
    public int getPrice(String menuName) {
        return Appetizer.valueOf(menuName).price;
    }
}
