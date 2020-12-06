

import java.util.Set;

public interface LottoInterface {


    Set<Integer> newDrawOfNumbers();

    Coupon createNewCoupon();

    boolean checkIfYouWin(Coupon coupon);


}
