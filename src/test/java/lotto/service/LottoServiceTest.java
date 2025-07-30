package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoServiceTest {
    
    @DisplayName("로또를 구매한다.")
    @Test
    void lottoNumbersAreNotSix() { // 성공 케이스 - 로또 구매에 성공한 경우
        // given
        int pay = 8000;
        LottoService lottoService = new LottoService();
        
        // when & then
        assertThat(lottoService.buyLotto(pay)).isEqualTo(8);
    }
    
    @DisplayName("로또 구매에 실패한다.")
    @Test
    void lottoNumbersAreSix() { // 실패 케이스 - 로또 구매에 실패한 경우
        // given
        int pay = 7500;
        LottoService lottoService = new LottoService();
        
        // when & then
        assertThatThrownBy(() -> lottoService.buyLotto(pay))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("로또를 발행한다.")
    @Test
    void issueLotterySuccess() { // 성공 케이스 - 로또 발행에 성공한 경우
        // given
        int pay = 8000;
        LottoService lottoService = new LottoService();
        int count = lottoService.buyLotto(pay);
        
        // when & then
        assertThatCode(() -> lottoService.issueLotto(count))
                .doesNotThrowAnyException();
    }
    
    @DisplayName("로또 발행에 실패한다.")
    @Test
    void issueLotteryFail() { // 실패 케이스 - 로또 발행에 실패한 경우
        // given
        int pay = 7500;
        LottoService lottoService = new LottoService();
        
        // when & then
        assertThatThrownBy(() -> lottoService.issueLotto(lottoService.buyLotto(pay)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("로또 당첨 여부를 확인한다.")
    @Test
    void confirmWinningSuccess() { // 성공 케이스 - 로또 당첨 여부 확인에 성공한 경우
        // given
        LottoService lottoService = new LottoService();
        List<Integer>[] tmpIssuedLotto = new List[1];
        tmpIssuedLotto[0] = List.of(1, 2, 3, 4, 5, 6);
        
        // when & then
        assertThatCode(() -> lottoService.confirmWinning(List.of(1, 2, 3, 4, 5, 6), List.of(7), tmpIssuedLotto))
                .doesNotThrowAnyException();
    }
    
    @DisplayName("로또 당첨 여부 확인에 실패한다.")
    @Test
    void confirmWinningFail() { // 실패 케이스 - 로또 당첨 여부 확인에 실패한 경우
        // given
        LottoService lottoService = new LottoService();
        List<Integer>[] tmpIssuedLotto = new List[1];
        tmpIssuedLotto[0] = List.of(1, 2, 3, 4, 5);
        
        // when & then
        assertThatThrownBy(() -> lottoService.confirmWinning(List.of(1, 2, 3, 4, 5, 6), List.of(7), tmpIssuedLotto))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }
    
    @DisplayName("로또 당첨 통계를 낸다.")
    @Test
    void compileStatisticsSuccess() { // 성공 케이스 - 로또 당첨 통계를 내는데 성공한 경우
        // given
        int[] rank = new int[5];
        LottoService lottoService = new LottoService();
        
        // when & then
        assertThatCode(() -> lottoService.compileStatistics(rank))
                .doesNotThrowAnyException();
    }
    
    @DisplayName("로또 당첨 통계를 내는데 실패한다.")
    @Test
    void compileStatisticsFail() { // 실패 케이스 - 로또 당첨 통계를 내는데 실패한 경우
        // given
        int[] rank = new int[4];
        LottoService lottoService = new LottoService();
        
        // when & then
        assertThatThrownBy(() -> lottoService.compileStatistics(rank))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("로또 수익률을 낸다.")
    @Test
    void findTheRateOfReturnSuccess() { // 성공 케이스 - 로또 수익률을 구하는데 성공한 경우
        // given
        int pay = 8000;
        long totalWinnings = 2000000000L;
        LottoService lottoService = new LottoService();
        
        // when & then
        assertThatCode(() -> lottoService.findTheRateOfReturn(pay, totalWinnings))
                .doesNotThrowAnyException();
    }
    
    @DisplayName("로또 수익률을 내지 못한다.")
    @Test
    void findTheRateOfReturnFail() { // 실패 케이스 - 로또 수익률을 구하는데 실패한 경우
        // given
        int pay = 8000;
        long totalWinnings = -2000000000L;
        LottoService lottoService = new LottoService();
        
        // when & then
        assertThatThrownBy(() -> lottoService.findTheRateOfReturn(pay, totalWinnings))
                .isInstanceOf(IllegalArgumentException.class);
    }
}