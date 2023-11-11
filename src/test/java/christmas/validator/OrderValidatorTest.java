package christmas.validator;

import christmas.domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static christmas.validator.OrderValidator.*;
import static org.assertj.core.api.Assertions.*;

public class OrderValidatorTest {

    @Test
    @DisplayName("음료만 주문하는 경우는 주문을 받지 않는다")
    void orderOnlyBeverageTest() {
        //given
        Order zeroCola = new Order("제로콜라", 3);
        Order redWine = new Order("레드와인", 2);

        //when
        List<Order> orders = new ArrayList<>();
        orders.add(zeroCola);
        orders.add(redWine);

        //then
        assertThatThrownBy(() -> validateOrderOnlyBeverage(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주문 사항에 같은 메뉴가 두 번 이상 들어가지 않는다")
    void orderDuplicateTest() {
        //given
        Order order1 = new Order("초코케이크", 3);
        Order order2 = new Order("초코케이크", 2);

        //when
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        //then
        assertThatThrownBy(() -> validateDuplicateOrder(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("메뉴는 최대 20개까지만 주문 가능하다")
    void orderCountMaximumRangeTest() {
        //given
        Order order1 = new Order("초코케이크", 15);
        Order order2 = new Order("레드와인", 6);

        //when
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        //then
        assertThatThrownBy(() -> validateOrderCount(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("메뉴는 1개 이상부터 주문 가능하다")
    void orderCountMinimumRangeTest() {
        //given
        Order order1 = new Order("초코케이크", 0);

        //when
        List<Order> orders = new ArrayList<>();
        orders.add(order1);

        //then
        assertThatThrownBy(() -> validateOrderCount(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
