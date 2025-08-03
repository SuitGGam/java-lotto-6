package lotto.exception;

public class LottoException {

    public class LottoNumberCountException extends RuntimeException {
        public LottoNumberCountException(String message) {
            super(message);
        }
    }

    public class LottoNumberRangeException extends RuntimeException {
        public LottoNumberRangeException(String message) {
            super(message);
        }
    }

    public class LottoNumberDuplicatedException extends RuntimeException {
        public LottoNumberDuplicatedException(String message) {
            super(message);
        }
    }

    public class LottoUnitException extends RuntimeException {
        public LottoUnitException(String message) {
            super(message);
        }
    }
}