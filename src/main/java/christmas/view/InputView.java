package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import static christmas.util.InputConstant.*;
import static christmas.validator.VisitDayValidator.validateDay;

public class InputView {

    public static void introduction() {
        System.out.println(INTRODUCTION_FOR_CUSTOMER);
    }

    public static int readDate() {
        System.out.println(EXPECTED_VISIT_DATE);
        try {
            String input = Console.readLine();
            validateDay(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_DATE);
            return readDate();
        }
    }

    public static String[] orderMenuWithAmount() {
        try {
            System.out.println(ORDER_MENU_WITH_AMOUNT);
            String input = Console.readLine();
            return input.split(MENU_DELIMITER);
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_ORDER);
            return orderMenuWithAmount();
        }
    }

    public static void printEventBenefits(int day) {
        System.out.printf(SHOW_EVENT_BENEFIT, day);
    }

}
