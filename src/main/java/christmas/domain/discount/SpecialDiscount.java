package christmas.domain.discount;

public class SpecialDiscount implements Discount{

    private final int discountFixAmount = 1000;

    @Override
    public int discount(int day) {
        if(day % 7 == 3 || day == 25){
            return discountFixAmount;
        }
        return 0;
    }
}
