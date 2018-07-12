package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;


public class HotelsDetailsPage extends BasePage {

    @FindBy(xpath="//button[text()='Book Now'][@type=\"submit\"]")
    private List<WebElement> bookNow;

    public HotelsDetailsPage(WebDriver driver){
        super(driver);
    }


    public BookHotelPage clickBookNow(){
        Iterator<WebElement> bookHotel = bookNow.iterator();
        WebElement firstBookNow= bookHotel.next();

        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",firstBookNow);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(firstBookNow));

        firstBookNow.click();
        return new BookHotelPage(driver);
    }






}
