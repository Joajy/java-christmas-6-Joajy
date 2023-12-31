package christmas.domain.menu;

public enum Main implements Menu{
    티본스테이크("티본스테이크", 55000),
    바비큐립("바비큐립", 54000),
    해산물파스타("해산물파스타", 35000),
    크리스마스파스타("크리스마스파스타", 25000);

    private final int price;

    Main(String menuName, int price) {
        this.price = price;
    }

    @Override
    public int getPrice(String menuName) {
        return Main.valueOf(menuName).price;
    }
}
