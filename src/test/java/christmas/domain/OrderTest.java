package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    @DisplayName("하나의 상품에 대한 주문 내역 금액이 제대로 적용되는지 확인")
    void orderPriceTest() {
        //given
        Order order = new Order("티본스테이크", "2");

        //when

        //then
        assertEquals(order.menuTotalPrice(), 110000);
    }

    @Test
    @DisplayName("주문 수량이 제대로 입력되었는지 확인")
    void orderAmountTest() {
        //given
        Order order = new Order("티본스테이크", "2");

        //when

        //then
        assertEquals(order.getOrderAmount(), 2);
    }
}
