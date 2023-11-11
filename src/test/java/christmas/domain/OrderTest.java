package christmas.domain;

import christmas.domain.menu.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    @DisplayName("메뉴에 없는 항목을 추가할 경우 문제 발생하는지 확인")
    void orderNotInMenuTest() {
        //given

        //when

        //then
        assertThatThrownBy(() -> new Order("초코", 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("하나의 상품에 대한 주문 내역 금액이 제대로 적용되는지 확인")
    void orderPriceTest() {
        //given
        Order order = new Order("티본스테이크", 2);

        //when

        //then
        assertEquals(order.getOrderAmount() * order.getCategory().getPrice(order.getMenuName()), 110000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크", "해산물파스타"})
    @DisplayName("주문 상품이 알맞은 카테고리를 가지고 있는지 확인")
    void orderCategoryTest(String menu) {
        //given
        Order order = new Order(menu, 2);

        //when

        //then
        assertThat(order.getCategory()).isInstanceOf(Main.class);
    }

    @Test
    @DisplayName("주문 수량이 제대로 입력되었는지 확인")
    void orderAmountTest() {
        //given
        Order order = new Order("티본스테이크", 2);

        //when

        //then
        assertEquals(order.getOrderAmount(), 2);
    }
}
