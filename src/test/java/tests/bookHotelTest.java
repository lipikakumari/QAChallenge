package tests;

import Pages.HomePage;
import base.BaseDriver;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class bookHotelTest extends BaseDriver {




    @Test  //Should book hotel as Guest"
    public void bookHotelAsGuestWithDefaultValues() {
        assertTrue(
                new HomePage(driver)
                .clickHotelsTab()
                .clickHotelsDetails()
                .clickBookNow()
                .enterFirstName("FirstName").enterLastName("LastName").enterEmail("test@gmail.com").confirmEmail("test@gmail.com")
                .confirmBooking()
                        .waitForInvoiceToBeGenerated()
        );
    }




}
