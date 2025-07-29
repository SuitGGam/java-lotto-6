package lotto.domain;

import java.util.List;

public class Lotto {
    
    private static final int LOTTO_PRICE = 1_000;
    
    private final List<Integer> numbers;
    
    public int lottoPrice() {
        return LOTTO_PRICE;
    }
    
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

}