package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class InvoicePage extends BasePage {

    @FindBy(xpath="//strong[text()='Booking Code']")
    private WebElement bookingCode;


    public InvoicePage(WebDriver driver){
        super(driver);
    }

    public  boolean waitForInvoiceToBeGenerated(){
        try {

            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(bookingCode));
            return true;
        }catch(Exception e){
            e.getMessage();
            return false;
        }

    }


}
