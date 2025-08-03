package lotto.validation;

import lotto.domain.LottoConstants;
import lotto.exception.LottoNumberRangeException;
import lotto.exception.LottoNumberDuplicatedException;

import java.util.List;

public class BonusNumberValidation {

    public boolean isValidRange(int bonusNumber) {
        if (bonusNumber < LottoConstants.LOTTO_NUMBER_MIN || bonusNumber > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new LottoNumberRangeException("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자로 입력해 주세요.");
        }

        return true;
    }

    public boolean isDuplicated(List<Integer> lottoNumbers, int bonusNumber) {
        for (Integer number : lottoNumbers) {
            if (number == bonusNumber)
            throw new LottoNumberDuplicatedException("[ERROR] 로또 번호와 보너스 번호에 중복이 있으면 안 됩니다.");
        }

        return true;
    }
}