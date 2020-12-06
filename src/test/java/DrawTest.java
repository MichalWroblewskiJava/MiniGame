import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.util.Sets;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.Instant;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class DrawTest {

    private Draw draw;

    private Object[] getData() {
        Integer[] sourceArrayPicked1 = {1, 2, 3, 4, 5, 6};
        Integer[] sourceArrayPicked2 = {1, 2, 20, 4, 99, 7};

        Set<Integer> pickedNumber1 = new HashSet<Integer>(Arrays.asList(sourceArrayPicked1));
        Set<Integer> pickedNumber2 = new HashSet<Integer>(Arrays.asList(sourceArrayPicked2));

        Coupon coupon1 = new Coupon();
        coupon1.setPickedNumbers(pickedNumber1);
        coupon1.setWinner(true);

        Coupon coupon2 = new Coupon();
        coupon2.setPickedNumbers(pickedNumber2);
        coupon2.setWinner(false);

        return new Object[]{
                new Object[]{coupon1, true},
                new Object[]{coupon2, false}

        };
    }

    @Before
    public void testSetup() {
        draw = new Draw();
    }

    @Test
    public void generateSixRandomNumbersTest() {
        Set<Integer> sixRandomNumbers = draw.newDrawOfNumbers();
        assertEquals(sixRandomNumbers.size(), 6);
        for (int randomInt : sixRandomNumbers) {
            assertThat(randomInt).isBetween(1, 99);
        }
    }

    @Test
    @Parameters(method = "getData")
    public void checkIfIsWinnerTest(Coupon coupon, boolean expected) {
        boolean isWinner = draw.checkIfYouWin(coupon);
        assertEquals(expected, isWinner);

    }
}

