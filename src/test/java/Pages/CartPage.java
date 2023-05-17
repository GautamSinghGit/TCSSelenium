package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CartPage {

    private WebDriver driver;

    @FindBy(css = ".cart h3")
    private List<WebElement> productsInCart;

    @FindBy(css = ".totalRow>button")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public List<String> validateProductsCountAddedIntoCart(){

        List<String> productsTextListFromCart = productsInCart.stream().map(WebElement::getText).toList();
        return productsTextListFromCart;


    }

    public PaymentPage clickOnCheckOutButton(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.querySelector('.totalRow>button').click()");
        return new PaymentPage(driver);
    }

}
