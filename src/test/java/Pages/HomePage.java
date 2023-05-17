package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class HomePage {


private WebDriver driver;
    @FindBy(xpath = "//*[text()='Automation Practice']")
    private WebElement logo;

    @FindBy(css = ".card-body h5")
    private List<WebElement> productName;

    @FindBy(css = ".toast-success")
    private WebElement successMsg;

    @FindBy(css = "[routerlink*='cart']")
    private WebElement cartButton;

   public HomePage(WebDriver driver){
       this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public boolean logoIsDisplayed(){
        return logo.isDisplayed();
    }

    public void clickOnCartForProducts(Object ...p){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".card-body h5"))));



        productName.forEach(e-> System.out.println(e.getText()));
      List<WebElement> addCartBu =  productName.stream().filter(e->Arrays.asList(p).contains(e.getText()))
                .map(e->e.findElement(By.xpath(".//following-sibling::button[2]"))).toList();

     for (int i=0;i<addCartBu.size();i++){

         addCartBu.get(i).click();
         if(i == addCartBu.size()-1)
             break;

         wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//ngx-spinner[contains(@class,'ng-star-inserted' )]/child::div/div[1]"))));



     }

    }

    public void clickOnCartForProducts(String prod){
       productName.stream().filter(e->e.getText().equals(prod))
               .map(e->e.findElement(By.xpath(".//following-sibling::button[2]"))).forEach(WebElement::click);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//ngx-spinner[contains(@class,'ng-star-inserted' )]/child::div/div[1]"))));



    }

    public boolean validateAddCartSuccessfullyMsgIsDisplayed(String p){

        clickOnCartForProducts(p);
        System.out.println(successMsg.getText());
       return successMsg.isDisplayed();
    }

    public CartPage clickOnCartButton(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//ngx-spinner[contains(@class,'ng-star-inserted' )]/child::div/div[1]"))));
        cartButton.click();
        return new CartPage(driver);
    }
}
