package lotto.validation;

import lotto.domain.LottoConstants;
import lotto.exception.LottoPriceUnitException;

public class PriceValidation {

    public boolean isMultiplesOfThousand(int pay) {
        if (pay % LottoConstants.LOTTO_PRICE != 0 && pay != 0) {
            throw new LottoPriceUnitException("[ERROR] 로또 구매 금액은 1,000원 단위로 입력해 주세요.");
        }

        return true;
    }
}
