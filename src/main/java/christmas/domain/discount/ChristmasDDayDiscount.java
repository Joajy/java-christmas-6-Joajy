package christmas.domain.discount;

public class ChristmasDDayDiscount implements Discount{

    private final int discountFixAmount = 1000;
    private final int discountPerDay = 100;

    @Override
    public int discount(int day) {
        if(day > 25){
            return 0;
        }
        return (day - 1) * discountPerDay + discountFixAmount;
    }
}
