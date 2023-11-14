package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.domain.EventBadge.*;
import static org.assertj.core.api.Assertions.assertThat;

public class EventBadgeTest {

    @Test
    @DisplayName("20000원 이상 할인된 경우 트리 뱃지를 주는지 확인")
    void giveEventBadgeTest() {
        //given

        //when

        //then
        assertThat(getEventBadge(20000)).isEqualTo("산타");
    }

    @Test
    @DisplayName("할인이 5000원 미만으로 적용된 경우 할인된 경우 뱃지를 받지 못한다")
    void cantGetEventBadgeTest() {
        //given

        //when

        //then
        assertThat(getEventBadge(4000)).isEqualTo("없음");
    }
}
