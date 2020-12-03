import java.util.Set;


public class Main {
    public static void main(String[] args) {

        Draw draw = new Draw();
        draw.startNewDraw();
        System.out.println(draw.getDrawNumbers());
        draw.createNewCoupon();
        Set<Coupon> couponsFromDraw = draw.getCouponsFromDraw();

        for (Coupon coupon : couponsFromDraw) {
            if (draw.isWinner(coupon)) {
                System.out.println("Gratulacje wygrałeś z liczbami: " + coupon.getPickedNumbers());
            } else {
                System.out.println("Bardzo nam przykto");

            }
        }

    }
}
