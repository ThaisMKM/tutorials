package baeldung.mockito.spy;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class DiscountCalculatorTest {

    @Test
    public void testDecemberDiscount() {
        // Creating an object for DiscountCalculator class and a spy for it
        DiscountCalculator discountCalculator = new DiscountCalculator();
        DiscountCalculator spyDiscountCalculator = spy(discountCalculator);

        // Setting up spy on getMonth method to return 12
        when(spyDiscountCalculator.getMonth()).thenReturn(12);

        // Testing the price with the regular object and the spy
        double discountedAmount = discountCalculator.calculatePrice(100.0);
        double spyDiscountedAmount = spyDiscountCalculator.calculatePrice(100.0);

        // note priced calculated with the regular object still depends on getMonth() for checking the correct discount
        if (discountCalculator.getMonth() == 12) {
            assert(discountedAmount == 80.0);
        } else {
            assert (discountedAmount == 100.0);
        }

        // note the priced calculated with the spy will always return same value
        assert(spyDiscountedAmount == 80.0);
    }

    @Test
    public void testDiscount() {

        DiscountCalculator discountCalculator = new DiscountCalculator();

        // Testing calculateDiscount method for any month
        double discountedAmount = discountCalculator.calculatePrice(100.0);

        if (discountCalculator.getMonth() == 12) {
            assert(discountedAmount == 80.0);
        } else {
            assert (discountedAmount == 100.0);
        }
    }
}
