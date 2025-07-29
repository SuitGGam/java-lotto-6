package lotto.validation;

import lotto.domain.LottoConstants;

public class PriceValidation {

    public boolean atLeastPay(int pay) {
        if (pay < LottoConstants.LOTTO_PRICE) return false;

        return true;
    }

    public boolean isMultiplesOfThousand(int pay) {
        if (pay % LottoConstants.LOTTO_PRICE != 0) return false;

        return true;
    }
}
