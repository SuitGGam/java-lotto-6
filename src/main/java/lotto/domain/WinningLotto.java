package lotto.domain;

import java.util.List;

public class WinningLotto {
    
    private final List<Integer> numbers;
    
    public WinningLotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

}