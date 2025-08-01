package lotto.exception;

import lotto.validation.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoExceptionTest {

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void lottoNumbersAreNotSix() { // 예외 발생 케이스 - 로또 번호가 6개가 아닌 경우
        // given
        LottoNumbersValidation lottoNumbersValidation = new LottoNumbersValidation();
        String expectedMessage = "[ERROR] 로또 번호는 6개를 입력해 주세요.";

        // when & then
        assertThatThrownBy(() -> lottoNumbersValidation.areSix(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @DisplayName("로또 번호의 개수가 6개면 예외가 발생하지 않는다.")
    @Test
    void lottoNumbersAreSix() { // 예외 미발생 케이스 - 로또 번호가 6개인 경우
        // given
        LottoNumbersValidation lottoNumbersValidation = new LottoNumbersValidation();

        // when & then
        assertThatCode(() -> lottoNumbersValidation.areSix(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }
    
    @DisplayName("로또 번호에 1 ~ 45 사이가 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void lottoNumbersAreNotInRange() { // 예외 발생 케이스 - 로또 번호가 범위를 벗어나는 경우
        // given
        LottoNumbersValidation lottoNumbersValidation = new LottoNumbersValidation();
        String expectedMessage = "[ERROR] 로또 번호는 1 ~ 45 사이의 숫자로 입력해 주세요.";
        
        // when & then
        assertThatThrownBy(() -> lottoNumbersValidation.areValidRange(List.of(1, 2, 3, 4, 5, 67)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
    
    @DisplayName("로또 번호에 1 ~ 45 사이의 숫자만 있으면 예외가 발생하지 않는다.")
    @Test
    void lottoNumbersAreInRange() { // 예외 미발생 케이스 - 로또 번호가 범위를 벗어나지 않는 경우
        // given
        LottoNumbersValidation lottoNumbersValidation = new LottoNumbersValidation();

        // when & then
        assertThatCode(() -> lottoNumbersValidation.areValidRange(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }
    
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void lottoNumbersAreDuplicated() { // 예외 발생 케이스 - 로또 번호가 중복되는 경우
        // given
        LottoNumbersValidation lottoNumbersValidation = new LottoNumbersValidation();
        String expectedMessage = "[ERROR] 로또 번호에 중복이 있으면 안 됩니다.";

        // when & then
        assertThatThrownBy(() -> lottoNumbersValidation.areDuplicated(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @DisplayName("로또 번호에 중복된 숫자가 없으면 예외가 발생하지 않는다.")
    @Test
    void lottoNumbersAreNotDuplicated() { // 예외 미발생 케이스 - 로또 번호가 중복되지 않는 경우
        // given
        LottoNumbersValidation lottoNumbersValidation = new LottoNumbersValidation();

        // when & then
        assertThatCode(() -> lottoNumbersValidation.areDuplicated(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }
    
    @DisplayName("보너스 번호의 개수가 1개가 아니면 예외가 발생한다.")
    @Test
    void bonusNumberIsNotOne() { // 예외 발생 케이스 - 보너스 번호가 1개가 아닌 경우
        // given
        BonusNumberValidation bonusNumberValidation = new BonusNumberValidation();
        String expectedMessage = "[ERROR] 보너스 번호는 1개만 입력해 주세요.";
        
        // when & then
        assertThatThrownBy(() -> bonusNumberValidation.isOne(List.of(1, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
    
    @DisplayName("보너스 번호의 개수가 1개면 예외가 발생하지 않는다.")
    @Test
    void bonusNumberIsOne() { // 예외 미발생 케이스 - 보너스 번호가 1개인 경우
        // given
        BonusNumberValidation bonusNumberValidation = new BonusNumberValidation();

        // when & then
        assertThatCode(() -> bonusNumberValidation.isOne(List.of(1)))
                .doesNotThrowAnyException();
    }
    
    @DisplayName("보너스 번호에 1 ~ 45 사이가 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void bonusNumberIsNotInRange() { // 예외 발생 케이스 - 보너스 번호가 범위를 벗어나는 경우
        // given
        BonusNumberValidation bonusNumberValidation = new BonusNumberValidation();
        String expectedMessage = "[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자로 입력해 주세요.";
        
        // when & then
        assertThatThrownBy(() -> bonusNumberValidation.isValidRange(List.of(67)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
    
    @DisplayName("보너스 번호에 1 ~ 45 사이의 숫자만 있으면 예외가 발생하지 않는다.")
    @Test
    void bonusNumberIsInRange() { // 예외 미발생 케이스 - 보너스 번호가 범위를 벗어나지 않는 경우
        // given
        BonusNumberValidation bonusNumberValidation = new BonusNumberValidation();

        // when & then
        assertThatCode(() -> bonusNumberValidation.isValidRange(List.of(1)))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void bonusNumberIsDuplicated() { // 예외 발생 케이스 - 로또 번호와 보너스 번호가 중복되는 경우
        // given
        BonusNumberValidation bonusNumberValidation = new BonusNumberValidation();
        String expectedMessage = "[ERROR] 로또 번호와 보너스 번호에 중복이 있으면 안 됩니다.";

        // when & then
        assertThatThrownBy(() -> bonusNumberValidation.isDuplicated(List.of(1, 2, 3, 4, 5, 6), List.of(6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @DisplayName("로또 번호와 보너스 번호가 중복되지 않으면 예외가 발생하지 않는다.")
    @Test
    void bonusNumberIsNotDuplicated() { // 예외 미발생 케이스 - 로또 번호와 보너스 번호가 중복되지 않는 경우
        // given
        BonusNumberValidation bonusNumberValidation = new BonusNumberValidation();

        // when & then
        assertThatCode(() -> bonusNumberValidation.isDuplicated(List.of(1, 2, 3, 4, 5, 6), List.of(7)))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 구매 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void purchaseAmountIsNotMultiplesOfThousand() { // 예외 발생 케이스 - 로또 구매 금액이 1,000원 단위가 아닌 경우
        // given
        PriceValidation priceValidation = new PriceValidation();
        String expectedMessage = "[ERROR] 로또 구매 금액은 1,000원 단위로 입력해 주세요.";

        // when & then
        assertThatThrownBy(() -> priceValidation.isMultiplesOfThousand(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @DisplayName("로또 구매 금액이 1,000원 단위면 예외가 발생하지 않는다.")
    @Test
    void purchaseAmountIsMultiplesOfThousand() { // 예외 미발생 케이스 - 로또 구매 금액이 1,000원 단위인 경우
        // given
        PriceValidation priceValidation = new PriceValidation();

        // when & then
        assertThatCode(() -> priceValidation.isMultiplesOfThousand(3000))
                .doesNotThrowAnyException();
    }

    @DisplayName("구매 금액에 잘못된 입력 형식이 들어올 경우 예외가 발생한다")
    @Test
    void priceInputIsIncorrectFormat() { // 예외 발생 케이스 - 구매 금액 입력 형식이 잘못된 경우
        // given
        InputValidation inputValidation = new InputValidation();

        // when & then
        assertThatThrownBy(() -> inputValidation.inputOfPayIsCorrect("천원"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("구매 금액에 올바른 입력 형식이 들어올 경우 예외가 발생하지 않는다.")
    @Test
    void priceInputIsCorrectFormat() { // 예외 미발생 케이스 - 구매 금액 입력 형식이 올바른 경우
        // given
        InputValidation inputValidation = new InputValidation();

        // when & then
        assertThatCode(() -> inputValidation.inputOfPayIsCorrect("1000"))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호에 잘못된 입력 형식이 들어올 경우 예외가 발생한다")
    @Test
    void lottoNumberInputIsIncorrectFormat() { // 예외 발생 케이스 - 로또 번호 입력 형식이 잘못된 경우
        // given
        InputValidation inputValidation = new InputValidation();

        // when & then
        assertThatThrownBy(() -> inputValidation.inputOflottoNumbersIsCorrect("1 2 3 4 5 6"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("로또 번호에 올바른 입력 형식이 들어올 경우 예외가 발생하지 않는다.")
    @Test
    void lottoNumberInputIsCorrectFormat() { // 예외 미발생 케이스 - 로또 번호 입력 형식이 올바른 경우
        // given
        InputValidation inputValidation = new InputValidation();

        // when & then
        assertThatCode(() -> inputValidation.inputOflottoNumbersIsCorrect("1,2,3,4,5,6"))
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호에 잘못된 입력 형식이 들어올 경우 예외가 발생한다")
    @Test
    void bonusNumberInputIsIncorrectFormat() { // 예외 발생 케이스 - 보너스 번호 입력 형식이 잘못된 경우
        // given
        InputValidation inputValidation = new InputValidation();

        // when & then
        assertThatThrownBy(() -> inputValidation.inputOfBonusNumberIsCorrect("칠"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("보너스 번호에 올바른 입력 형식이 들어올 경우 예외가 발생하지 않는다.")
    @Test
    void bonusNumberInputIsCorrectFormat() { // 예외 미발생 케이스 - 보너스 번호 입력 형식이 올바른 경우
        // given
        InputValidation inputValidation = new InputValidation();

        // when & then
        assertThatCode(() -> inputValidation.inputOfBonusNumberIsCorrect("7"))
                .doesNotThrowAnyException();
    }
}