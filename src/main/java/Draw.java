
import java.util.*;
import java.util.stream.Collectors;

class Draw implements LottoInterface {
    private Set<Integer> drawNumbers = new HashSet<>();
    private Set<Coupon> coupons = new HashSet<>();


    private Set<Integer> pickSixNumbers() {
        System.out.println();
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
                    throw new IllegalArgumentException();
                }
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Nie podałeś liczby od 1 do 99");
                e.printStackTrace();
            }
        }
        return pickedSixNumbers;
    }

    @Override
    public Coupon createNewCoupon() {
        Coupon coupon = new Coupon();
        coupon.setPickedNumbers(pickSixNumbers());
        coupon.setWinner(false);
        this.coupons.add(coupon);
        return coupon;
    }

    @Override
    public Set<Integer> newDrawOfNumbers() {
        final Random random = new Random();
        while (this.drawNumbers.size() < 6) {
            drawNumbers.add(random.nextInt(99) + 1);
        }
        for (Coupon coupon : this.coupons) {
            isWinner(coupon);
        }
        return drawNumbers;
    }

    private void isWinner(Coupon coupon) {
        if (this.drawNumbers.equals(coupon.getPickedNumbers())) {
            coupon.setWinner(true);
        }
    }

    @Override
    public boolean checkIfYouWin(Coupon coupon) {
        System.out.println("Wylosowane liczby to: " + drawNumbers.stream()
                .sorted()
                .collect(Collectors.toList()));
        if (coupon.isWinnerCoupon()) {
            System.out.println("Gratulacje wygrałeś z liczbami: " + coupon.getPickedNumbers().stream()
                    .sorted()
                    .collect(Collectors.toList()));
            return true;
        } else {
            System.out.println("Nie wygrałeś, Twoje liczby to: " + coupon.getPickedNumbers().stream()
                    .sorted()
                    .collect(Collectors.toList()));
            return false;
        }
    }
}
