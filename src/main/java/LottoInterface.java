

import java.util.Set;

public interface LottoInterface {

    Set<Integer> pickSixNumbers();

    Set<Integer> newDraw();

    boolean isWinner(Coupon coupon);

    //void startLottoGame();
}
