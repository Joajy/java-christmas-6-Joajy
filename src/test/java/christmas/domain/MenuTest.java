package christmas.domain;

import christmas.domain.menu.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MenuTest {

    @Test
    @DisplayName("애피타이저 메뉴와 금액이 제대로 매칭되어 있는지 확인")
    void appetizerTest() {
        //given
        Menu menu = Appetizer.valueOf("시저샐러드");

        //when
        int money = menu.getPrice("시저샐러드");

        //then
        assertThat(money).isEqualTo(8000);
    }

    @Test
    @DisplayName("음료 메뉴와 금액이 제대로 매칭되어 있는지 확인")
    void beverageTest() {
        //given
        Menu menu = Beverage.valueOf("제로콜라");

        //when
        int money = menu.getPrice("제로콜라");

        //then
        assertThat(money).isEqualTo(3000);
    }

    @Test
    @DisplayName("디저트 메뉴와 금액이 제대로 매칭되어 있는지 확인")
    void dessertTest() {
        //given
        Menu menu = Dessert.valueOf("초코케이크");

        //when
        int money = menu.getPrice("초코케이크");

        //then
        assertThat(money).isEqualTo(15000);
    }

    @Test
    @DisplayName("메인 메뉴와 금액이 제대로 매칭되어 있는지 확인")
    void mainMenuTest() {
        //given
        Menu menu = Main.valueOf("티본스테이크");

        //when
        int money = menu.getPrice("티본스테이크");

        //then
        assertThat(money).isEqualTo(55000);
    }
}
