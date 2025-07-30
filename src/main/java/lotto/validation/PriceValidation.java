package lotto.validation;

import lotto.domain.LottoConstants;

public class PriceValidation {

    public boolean atLeastPay(int pay) {
        if (pay < LottoConstants.LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 최소 금액은 1,000원입니다.");
        }

        return true;
    }

    public boolean isMultiplesOfThousand(int pay) {
        if (pay % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1,000원 단위로 입력해 주세요.");
        }

        return true;
    }
}
