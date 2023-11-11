package christmas.validator;

public class VisitDayValidator {

    private static final String REGEX = "^[0-9]+$";

    public static void validateDay(String day) {
        validateNumber(day);
        validateOutOfRange(day);
    }

    public static void validateOutOfRange(String day) {
        int date = Integer.parseInt(day);
        if(date < 1 || date > 31){
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumber(String day) {
        if(!day.matches(REGEX)){
            throw new NumberFormatException();
        }
    }
}
