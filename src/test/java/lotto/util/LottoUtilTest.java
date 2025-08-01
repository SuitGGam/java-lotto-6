package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoUtilTest {
    
    @DisplayName("문자열을 정수형 변환에 성공한다.")
    @Test
    void lottoNumbersAreNotSix() { // 성공 케이스 - 문자열을 정수형 변환에 성공한 경우
        // given
        LottoUtil lottoUtil = new LottoUtil();
        
        // when & then
        assertThat(lottoUtil.preProcessStringToInteger("1,2,3,4,5,6"))
                .doesNotThrowAnyException();
    }
    
    @DisplayName("문자열을 정수형 변환에 실패한다.")
    @Test
    void lottoNumbersAreSix() { // 실패 케이스 - 문자열을 정수형 변환에 실패한 경우
        // given
        LottoUtil lottoUtil = new LottoUtil();
        
        // when & then
        assertThatThrownBy(() -> lottoUtil.preProcessStringToInteger("1.2.3.4.5.6"))
                .isInstanceOf(NumberformatException.class);
    }
}