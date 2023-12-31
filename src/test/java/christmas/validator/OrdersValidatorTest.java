package christmas.validator;

import christmas.domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static christmas.validator.OrdersValidator.*;
import static org.assertj.core.api.Assertions.*;

public class OrdersValidatorTest {

    @Test
    @DisplayName("음료만 주문하는 경우는 주문을 받지 않는다")
    void orderOnlyBeverageTest() {
        //given
        Order zeroCola = new Order("제로콜라", "3");
        Order redWine = new Order("레드와인", "2");

        //when
        List<Order> orders = new ArrayList<>();
        orders.add(zeroCola);
        orders.add(redWine);

        //then
        assertThatThrownBy(() -> validateOrdersOnlyBeverage(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주문 사항에 같은 메뉴가 두 번 이상 들어가지 않는다")
    void orderDuplicateTest() {
        //given
        Order order1 = new Order("초코케이크", "3");
        Order order2 = new Order("초코케이크", "2");

        //when
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        //then
        assertThatThrownBy(() -> validateDuplicateOrders(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("메뉴는 최대 20개까지만 주문 가능하다")
    void orderCountMaximumRangeTest() {
        //given
        Order order1 = new Order("초코케이크", "15");
        Order order2 = new Order("레드와인", "6");

        //when
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        //then
        assertThatThrownBy(() -> validateOrdersCount(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("단일 주문 수량에서 0개 이하로 주문할 수 없다")
    void orderMinimumOutOfRangeTest() {
        //given

        //when

        //then
        assertThatThrownBy(() -> new Order("티본스테이크", "0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("단일 주문 수량에서 20개를 넘게 주문할 수 없다")
    void orderMaximumOutOfRangeTest() {
        //given

        //when

        //then
        assertThatThrownBy(() -> new Order("티본스테이크", "22"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("총 주문 수량이 20개를 넘을 수 없다")
    void ordersMaximumOutOfRangeTest() {
        //given
        List<Order> orders = new ArrayList<>();

        //when
        orders.add(new Order("티본스테이크", "5"));
        orders.add(new Order("초코케이크", "10"));
        orders.add(new Order("제로콜라", "10"));

        //then
        assertThatThrownBy(() -> validateOrdersCount(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("메뉴에 없는 항목을 추가할 경우 문제 발생하는지 확인")
    void orderNotInMenuTest() {
        //given

        //when

        //then
        assertThatThrownBy(() -> new Order("초코", "2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주문 항목에 아무것도 대입되지 않았는지 확인")
    void orderIsEmptyTest(){
        //given

        //when

        //then
        assertThatThrownBy(() -> validateEmptyInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
