package lotto.validation;

import lotto.domain.LottoConstants;

public class InputValidation {

    public boolean inputOfPayIsCorrect(String pay) {
        Integer value = Integer.parseInt(pay);
        if (!(value instanceof Integer)) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자만 입력해 주세요.");
        }
        
        return true;
    }

    public boolean inputOflottoNumbersIsCorrect(String lottoNumbers) {
        String[] tmp = lottoNumbers.split(",");
        Integer[] numbers = new Integer[LottoConstants.LOTTO_NUMBER_COUNT];
        for (int i = 0; i < LottoConstants.LOTTO_NUMBER_COUNT; i++) {
            numbers[i] = Integer.parseInt(tmp[i]);
        }
        
        if (!(numbers instanceof Integer[])) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자와 ,로만 입력해 주세요.");
        }
        
        return true;
    }

    public boolean inputOfBonusNumberIsCorrect(String bonusNumber) {
        Integer value = Integer.parseInt(bonusNumber);
        if (!(value instanceof Integer)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력해 주세요.");
        }
        
        return true;
    }
}