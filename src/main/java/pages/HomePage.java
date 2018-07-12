package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage {
    @FindBy(css="a[title='Hotels']")
    private WebElement hotelsTab;


    public HomePage(WebDriver driver){
        super(driver);
    }

    public HotelsPage clickHotelsTab(){
        this.hotelsTab.click();
        return new HotelsPage(driver);
    }

}
