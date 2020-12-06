

public class Main {
    public static void main(String[] args) {

        Draw draw = new Draw();
        Coupon newCoupon = draw.createNewCoupon();
        draw.newDrawOfNumbers();
        draw.checkIfYouWin(newCoupon);
    }
}

