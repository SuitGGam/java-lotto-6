package lotto.domain;

import java.util.List;

public class Lotto {
    
    private List<Integer> winningLotto;
    
    private int pay;
    private int lottiesCount;
    private List<Integer>[] issuedLotties;
    private int[] rank;
    
    public List<Integer> getWinningLotto()    { return winningLotto; }
    
    public int getPay()                       { return pay; }
    public int getLottiesCount()              { return lottiesCount; }
    public List<Integer>[] getIssuedLotties() { return issuedLotties; }
    public int[] getRank()                    { return rank; }
}