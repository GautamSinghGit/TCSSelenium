package Pages;

import org.bouncycastle.est.LimitedSource;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentPage {

    private WebDriver driver;
    @FindBy(css = "[placeholder='Select Country']")
    private WebElement countryInbox;

    @FindBy(css = ".list-group button")
    private List<WebElement> countryList;

    @FindBy(css = "input[placeholder*='Country']+section")
    private WebElement countyListBox;


    public PaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void selectCountryName(String countryName){
        countryInbox.sendKeys(countryName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(countyListBox));

        ((JavascriptExecutor)driver).executeScript("document.querySelector('button.ta-item:last-of-type').click()");

      }


}
