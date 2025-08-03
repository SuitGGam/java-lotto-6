package lotto.validation;

import lotto.exception.LottoNumberCountException;
import lotto.exception.LottoNumberDuplicatedException;
import lotto.exception.LottoNumberRangeException;
import lotto.exception.LottoPriceUnitException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoValidationTest {

    @DisplayName("로또 구매 금액이 숫자로만 이루어져 있어야 한다.")
    @Test
    void priceInputIsCorrect() { // 성공 케이스 - 구매 금액 입력 형식이 올바른 경우
        // given
        String pay = "1000";
        InputValidation inputValidation = new InputValidation();

        // when & then
        assertThat(inputValidation.inputOfPayIsCorrect(pay)).isEqualTo(true);
    }

    @DisplayName("로또 구매 금액이 숫자 외의 것들로 이루어져 있다.")
    @Test
    void priceInputIsIncorrect() { // 실패 케이스 - 구매 금액 입력 형식이 올바르지 않은 경우
        // given
        String pay = "1,000";
        InputValidation inputValidation = new InputValidation();
        
        // when & then
        assertThatThrownBy(() -> inputValidation.inputOfPayIsCorrect(pay))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("로또 번호가 숫자와 ,로만 이루어져 있어야 한다.")
    @Test
    void lottoNumbersInputIsCorrect() { // 성공 케이스 - 로또 번호 입력 형식이 올바른 경우
        // given
        String lottoNumbers = "1,2,3,4,5,6";
        InputValidation inputValidation = new InputValidation();

        // when & then
        assertThat(inputValidation.inputOflottoNumbersIsCorrect(lottoNumbers)).isEqualTo(true);
    }

    @DisplayName("로또 번호가 숫자와 ,외의 것들로 이루어져 있다.")
    @Test
    void lottoNumbersInputIsIncorrect() { // 실패 케이스 - 로또 번호 입력 형식이 올바르지 않은 경우
        // given
        String lottoNumbers = "1.2.3.4.5.6";
        InputValidation inputValidation = new InputValidation();

        // when & then
        assertThatThrownBy(() -> inputValidation.inputOflottoNumbersIsCorrect(lottoNumbers))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("보너스 번호가 숫자로만 이루어져 있어야 한다.")
    @Test
    void bonusNumberInputIsCorrect() { // 성공 케이스 - 보너스 번호 입력 형식이 올바른 경우
        // given
        String bounsNumber = "7";
        InputValidation inputValidation = new InputValidation();

        // when & then
        assertThat(inputValidation.inputOfBonusNumberIsCorrect(bounsNumber)).isEqualTo(true);
    }

    @DisplayName("보너스 번호가 숫자 외의 것들로 이루어져 있다.")
    @Test
    void bonusNumberInputIsIncorrect() { // 실패 케이스 - 보너스 번호 입력 형식이 올바르지 않은 경우
        // given
        String bounsNumber = "칠";
        InputValidation inputValidation = new InputValidation();
        
        // when & then
        assertThatThrownBy(() -> inputValidation.inputOfBonusNumberIsCorrect(bounsNumber))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("로또 구매 금액이 1000원 단위이다.")
    @Test
    void lottoPayInputIsMultiplesOfThousand() { // 성공 케이스 - 로또 구매 금액이 1000원 단위인 경우
        // given
        int pay = 3000;
        PriceValidation priceValidation = new PriceValidation();

        // when & then
        assertThat(priceValidation.isMultiplesOfThousand(pay)).isEqualTo(true);
    }

    @DisplayName("로또 구매 금액이 1000원 단위가 아니다.")
    @Test
    void lottoPayInputIsNotMultiplesOfThousand() { // 실패 케이스 - 로또 구매 금액이 1000원 단위가 아닌 경우
        // given
        int pay = 1500;
        PriceValidation priceValidation = new PriceValidation();
        String expectedMessage = "[ERROR] 로또 구매 금액은 1,000원 단위로 입력해 주세요.";
        
        // when & then
        assertThatThrownBy(() -> priceValidation.isMultiplesOfThousand(pay))
                .isInstanceOf(LottoPriceUnitException.class)
                .hasMessageContaining(expectedMessage);
    }

    @DisplayName("로또 번호가 6개이다.")
    @Test
    void lottoNumbersAreSix() { // 성공 케이스 - 로또 번호가 6개인 경우
        // given
        LottoNumbersValidation lottoNumbersValidation = new LottoNumbersValidation();

        // when & then
        assertThat(lottoNumbersValidation.areSix(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(true);
    }

    @DisplayName("로또 번호가 6개가 아니다.")
    @Test
    void lottoNumbersAreNotSix() { // 실패 케이스 - 로또 번호가 6개가 아닌 경우
        // given
        LottoNumbersValidation lottoNumbersValidation = new LottoNumbersValidation();
        String expectedMessage = "[ERROR] 로또 번호는 6개를 입력해 주세요.";
        
        // when & then
        assertThatThrownBy(() -> lottoNumbersValidation.areSix(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(LottoNumberCountException.class)
                .hasMessageContaining(expectedMessage);
    }

    @DisplayName("로또 번호가 1 ~ 45 범위 내에 있다.")
    @Test
    void lottoNumbersAreInRange() { // 성공 케이스 - 로또 번호가 1 ~ 45 범위 내에 있는 경우
        // given
        LottoNumbersValidation lottoNumbersValidation = new LottoNumbersValidation();

        // when & then
        assertThat(lottoNumbersValidation.areValidRange(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(true);
    }

    @DisplayName("로또 번호가 1 ~ 45 범위 밖에 있다.")
    @Test
    void lottoNumbersAreNotInRange() { // 실패 케이스 - 로또 번호가 1 ~ 45 범위 밖에 있는 경우
        // given
        LottoNumbersValidation lottoNumbersValidation = new LottoNumbersValidation();
        String expectedMessage = "[ERROR] 로또 번호는 1 ~ 45 사이의 숫자로 입력해 주세요.";
        
        // when & then
        assertThatThrownBy(() -> lottoNumbersValidation.areValidRange(List.of(1, 2, 3, 4, 5, 67)))
                .isInstanceOf(LottoNumberRangeException.class)
                .hasMessageContaining(expectedMessage);
    }

    @DisplayName("로또 번호에 중복이 없다.")
    @Test
    void lottoNumbersAreDuplicated() { // 성공 케이스 - 로또 번호가 중복이 없는 경우
        // given
        LottoNumbersValidation lottoNumbersValidation = new LottoNumbersValidation();

        // when & then
        assertThat(lottoNumbersValidation.areDuplicated(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(true);
    }

    @DisplayName("로또 번호에 중복이 있다.")
    @Test
    void lottoNumbersAreNotDuplicated() { // 실패 케이스 - 로또 번호가 중복이 있는 경우
        // given
        LottoNumbersValidation lottoNumbersValidation = new LottoNumbersValidation();
        String expectedMessage = "[ERROR] 로또 번호에 중복이 있으면 안 됩니다.";
        
        // when & then
        assertThatThrownBy(() -> lottoNumbersValidation.areDuplicated(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(LottoNumberDuplicatedException.class)
                .hasMessageContaining(expectedMessage);
    }

    @DisplayName("보너스 번호가 1 ~ 45 범위 내에 있다.")
    @Test
    void bonusNumberIsInRange() { // 성공 케이스 - 보너스 번호가 1 ~ 45 범위 내에 있는 경우
        // given
        BonusNumberValidation bonusNumberValidation = new BonusNumberValidation();

        // when & then
        assertThat(bonusNumberValidation.isValidRange(7)).isEqualTo(true);
    }

    @DisplayName("보너스 번호가 1 ~ 45 범위 밖에 있다.")
    @Test
    void bonusNumberIsNotInRange() { // 실패 케이스 - 보너스 번호가 1 ~ 45 범위 밖에 있는 경우
        // given
        BonusNumberValidation bonusNumberValidation = new BonusNumberValidation();
        String expectedMessage = "[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자로 입력해 주세요.";
        
        // when & then
        assertThatThrownBy(() -> bonusNumberValidation.isValidRange(67))
                .isInstanceOf(LottoNumberRangeException.class)
                .hasMessageContaining(expectedMessage);
    }

    @DisplayName("보너스 번호와 로또 번호에 중복이 없다.")
    @Test
    void bonusNumberIsDuplicated() { // 성공 케이스 - 보너스 번호와 로또 번호에 중복이 없는 경우
        // given
        BonusNumberValidation bonusNumberValidation = new BonusNumberValidation();

        // when & then
        assertThat(bonusNumberValidation.isDuplicated(List.of(1, 2, 3, 4, 5, 6), 7)).isEqualTo(true);
    }

    @DisplayName("보너스 번호와 로또 번호에 중복이 있다.")
    @Test
    void bonusNumberIsNotDuplicated() { // 실패 케이스 - 보너스 번호와 로또 번호에 중복이 있는 경우
        // given
        BonusNumberValidation bonusNumberValidation = new BonusNumberValidation();
        String expectedMessage = "[ERROR] 로또 번호와 보너스 번호에 중복이 있으면 안 됩니다.";
        
        // when & then
        assertThatThrownBy(() -> bonusNumberValidation.isDuplicated(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(LottoNumberDuplicatedException.class)
                .hasMessageContaining(expectedMessage);
    }
}