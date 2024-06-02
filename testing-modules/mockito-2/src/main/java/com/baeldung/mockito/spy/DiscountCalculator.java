package baeldung.mockito.spy;

import java.util.Calendar;

public class DiscountCalculator {

    // Method to get current month (1 -> Jan, ..., 12 -> Dec)
    public int getMonth() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.MONTH) + 1;
    }

    // This store is very cool and gives 20% discount on December
    public double calculatePrice(double amount) {
        return getMonth() == 12 ? amount * 0.8 : amount;
    }

}
