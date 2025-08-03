package lotto.util;

import lotto.domain.LottoConstants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtil {
    
    public int preProcessPay(String pay) {
        pay = (pay.replaceAll(",", "")).replaceAll("원", "");

        int value = Integer.parseInt(pay);
        
        return value;
    }
    
    public List<Integer> preProcessWinningLotto(String numbers) {
        return Arrays.stream(numbers.replaceAll(" ", "")
                .split(","))
                .limit(LottoConstants.LOTTO_NUMBER_COUNT)
                .map((Integer::parseInt))
                .collect(Collectors.toList());
    }
    
    public int preProcessBonusNumber(String number) {
        int bonusNumber = Integer.parseInt(number);
        
        return bonusNumber;
    }
}