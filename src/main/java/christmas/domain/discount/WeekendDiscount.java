package christmas.domain.discount;

public class WeekendDiscount implements Discount{

    private final int discountFixAmount = 2023;

    @Override
    public int discount(int day) {
        day %= 7;
        if(day == 1 || day == 2){
            return discountFixAmount;
        }
        return 0;
    }
}
