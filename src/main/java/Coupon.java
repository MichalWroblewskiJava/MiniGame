import java.util.Set;


class Coupon {
    private Set<Integer> pickedNumbers;
    private boolean isWinner;

    Coupon() {
    }

    public Set<Integer> getPickedNumbers() {
        return pickedNumbers;
    }

    void setPickedNumbers(Set<Integer> pickedNumbers) {
        this.pickedNumbers = pickedNumbers;
    }

    public boolean isWinnerCoupon() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}
