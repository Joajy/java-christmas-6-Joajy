package christmas.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.validator.VisitDayValidator.*;
import static org.assertj.core.api.Assertions.*;

public class VisitDayValidatorTest {

    @Test
    @DisplayName("날짜 입력은 숫자로만 입력받아야 한다")
    void inputOnlyNumberTest(){
        //given
        String day = "1일";

        //when

        //then
        assertThatThrownBy(() -> validateNumber(day))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("날짜 입력은 1 이상 31 이하의 값만 입력받아야 한다")
    void inputDateOutOfRangeTest(){
        //given
        String day = "33";

        //when

        //then
        assertThatThrownBy(() -> validateOutOfRange(day))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
