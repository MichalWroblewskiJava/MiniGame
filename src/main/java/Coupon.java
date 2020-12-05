import java.util.Set;


class Coupon {
    private Set<Integer> pickedNumbers;
    private boolean isWinner;

    Coupon() {
    }

    Set<Integer> getPickedNumbers() {
        return pickedNumbers;
    }

    void setPickedNumbers(Set<Integer> pickedNumbers) {
        this.pickedNumbers = pickedNumbers;
    }

    boolean isWinnerCoupon() {
        return isWinner;
    }

    void setWinner(boolean winner) {
        this.isWinner = winner;
    }
}
