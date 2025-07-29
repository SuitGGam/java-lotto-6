package lotto.domain;

import java.util.List;

public class WinningLotto {
    
    private final List<Integer> winningsNumbers;
    private final List<Integer> bounsNumber;
    
    public WinningLotto(List<Integer> winningsNumbers, List<Integer> bounsNumber) {
        this.winningsNumbers = winningsNumbers;
        this.bounsNumber = bounsNumber;
    }
}