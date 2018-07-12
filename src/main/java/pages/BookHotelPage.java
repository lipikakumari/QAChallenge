package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookHotelPage extends BasePage {

    @FindBy(xpath="//input[@name='firstname']")
    private WebElement firstName;

    @FindBy(xpath="//input[@name='lastname']")
    private WebElement lastName;

    @FindBy(xpath="//input[@name='email']")
    private WebElement email;

    @FindBy(xpath="//input[@name='confirmemail']")
    private WebElement confirmEmail;

    @FindBy(xpath="//button[@name='guest']")
    private WebElement guestBooking;


    public BookHotelPage(WebDriver driver){
        super(driver);
    }


    public BookHotelPage enterFirstName(String firstName){
        this.firstName.sendKeys(firstName);
        return this;
    }
    public BookHotelPage enterLastName(String lastName){
        this.lastName.sendKeys(lastName);
        return this;
    }

    public BookHotelPage enterEmail(String email){
       this.email.sendKeys(email);
       return this;
    }

    public BookHotelPage confirmEmail(String confirmEmail){
        this.confirmEmail.sendKeys(confirmEmail);
        return this;
    }

    public InvoicePage confirmBooking(){
        this.guestBooking.click();
        return new InvoicePage(driver);
    }

}
