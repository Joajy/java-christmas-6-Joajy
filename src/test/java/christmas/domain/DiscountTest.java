package christmas.domain;

import christmas.domain.discount.ChristmasDDayDiscount;
import christmas.domain.discount.SpecialDiscount;
import christmas.domain.discount.WeekdayDiscount;
import christmas.domain.discount.WeekendDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class DiscountTest {

    @Test
    @DisplayName("크리스마스 디데이 이벤트가 제대로 적용되는지 확인")
    void christmasDDayEventTest() {
        //given
        int day = 21;
        ChristmasDDayDiscount christmasDDayDiscount = new ChristmasDDayDiscount();
        //when

        //then
        assertThat(christmasDDayDiscount.discount(day)).isEqualTo(3000);
    }

    @Test
    @DisplayName("특별 할인이 제대로 적용되는지 확인")
    void specialEventTest() {
        //given
        int day = 10;
        SpecialDiscount specialDiscount = new SpecialDiscount();
        //when

        //then
        assertThat(specialDiscount.discount(day)).isEqualTo(1000);
    }

    @Test
    @DisplayName("평일 할인이 제대로 적용되는지 확인")
    void weekdayEventTest() {
        //given
        int day = 21;
        WeekdayDiscount weekdayDiscount = new WeekdayDiscount();
        //when

        //then
        assertThat(weekdayDiscount.discount(day)).isEqualTo(2023);
    }

    @ParameterizedTest
    @ValueSource(ints = {8, 15, 22})
    @DisplayName("주말 할인이 제대로 적용되는지 확인")
    void weekendEventTest(int day) {
        //given
        WeekendDiscount weekendDiscount = new WeekendDiscount();
        //when

        //then
        assertThat(weekendDiscount.discount(day)).isEqualTo(2023);
    }
}
