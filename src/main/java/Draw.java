
import java.util.*;
import java.util.stream.Stream;

class Draw implements LottoInterface {
    private Set<Integer> drawNumbers;
    private Set<Coupon> coupons;

    public Set<Integer> getDrawNumbers() {
        return drawNumbers;
    }

    public void startNewDraw() {
        this.coupons = new HashSet<>();
        this.drawNumbers = newDraw();
    }

    public Set<Coupon> getCouponsFromDraw() {
        return coupons;
    }

    public void createNewCoupon() {
        Coupon coupon = new Coupon();
        coupon.setPickedNumbers(pickSixNumbers());
        coupon.setWinner(false);
        this.coupons.add(coupon);
    }

    @Override
    public Set<Integer> pickSixNumbers() {
        System.out.println("Proszę podaj 6 róznych liczb od 1 do 99, każdą liczbę po wprowdzeniu zatwierdz klawiszem Enter");
        Set<Integer> pickedSixNumbers = new HashSet<>();
        while (pickedSixNumbers.size() < 6) {
            Scanner in = new Scanner(System.in);
            try {
                int inputInt = in.nextInt();
                if (inputInt > 0 && inputInt < 100) {
                    Optional<Integer> optionalCheck = pickedSixNumbers.stream()
                            .filter(i -> i == inputInt)
                            .findFirst();
                    optionalCheck.ifPresentOrElse(i -> System.out.println("Podałeś już liczbę: " + inputInt),
                            () -> pickedSixNumbers.add(inputInt));
                } else {
                    System.out.println("Podana liczba nie jest z zakresu od 1 do 99");
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Nie podałeś liczby od 1 do 99");
                e.printStackTrace();
            }
        }
        return pickedSixNumbers;
    }

    @Override
    public Set<Integer> newDraw() {
        final Random random = new Random();
        final Set<Integer> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < 6) {
            lottoNumbers.add(random.nextInt(99) + 1);
        }
        return lottoNumbers;
    }


    @Override
    public boolean isWinner(Coupon coupon) {
        if (this.drawNumbers.equals(coupon.getPickedNumbers())) {
            coupon.setWinner(true);
            return coupon.isWinnerCoupon();
        } else {
            return false;
        }
    }
}
