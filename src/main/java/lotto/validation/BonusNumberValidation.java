package lotto.validation;

import lotto.domain.LottoConstants;

import java.util.List;

public class BonusNumberValidation {

    public boolean isOne(List<Integer> bonusNumber) {
        if (bonusNumber.size() != LottoConstants.BONUS_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개만 입력해 주세요.");
        }

        return true;
    }

    public boolean isValidRange(List<Integer> bonusNumber) {
        if (bonusNumber.get(0) < LottoConstants.LOTTO_NUMBER_MIN || bonusNumber.get(0) > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자로 입력해 주세요.");
        }

        return true;
    }

    public boolean isDuplicated(List<Integer> lottoNumbers, List<Integer> bonusNumber) {
        for (Integer number : lottoNumbers) {
            if (number == bonusNumber.get(0))
            throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호에 중복이 있으면 안 됩니다.");
        }

        return true;
    }
}