package lotto.view;

import lotto.service.LottoService;

import java.util.List;

public class LottoOutputView {

    public void outputProcessIssuedLotties(List<Integer>[] issuedLotties) {
        StringBuilder sb = new StringBuilder();
        int len = issuedLotties.length;
        
        sb.append(len).append("개를 구매했습니다.").append("\n");
        for (int i = 0; i < len; i++) {
            sb.append(issuedLotties[i].toString()).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public void outputProcessStatistics(int pay, int[] rank) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("당첨 통계\n").append("---\n");
        sb.append("3개 일치 (5,000원) - ").append(rank[0]).append("개\n");
        sb.append("4개 일치 (50,000원) - ").append(rank[1]).append("개\n");
        sb.append("5개 일치 (1,500,000원) - ").append(rank[2]).append("개\n");
        sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(rank[3]).append("개\n");
        sb.append("6개 일치 (2,000,000,000원) - ").append(rank[4]).append("개\n");
        
        LottoService lottoService = new LottoService();
        long totalWinning = lottoService.compileStatistics(rank);
        
        double theRateOfReturn = lottoService.findTheRateOfReturn(pay, totalWinning);
        sb.append("총 수익률은 ").append(theRateOfReturn).append("%입니다.");
        
        System.out.print(sb);
    }
}