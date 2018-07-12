package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;


public class HotelsPage extends BasePage {

    @FindBy(xpath="//button[text()='Details']")
    private List<WebElement>  hotelDetails;

    public HotelsPage(WebDriver driver){
        super(driver);
    }


    public HotelsDetailsPage clickHotelsDetails(){
        Iterator<WebElement> hotelDetail = hotelDetails.iterator();
        if(hotelDetail.hasNext()) {
            hotelDetail.next().click();
        }
        return new HotelsDetailsPage(driver);
    }
}