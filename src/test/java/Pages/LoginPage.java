package Pages;

import Base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class LoginPage {


    private WebDriver driver;

    @FindBy(id = "userEmail")
    private WebElement username;

    @FindBy(css = "#userPassword")
    private WebElement password;

    @FindBy(css = "input[id='login']")
    private WebElement signIn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public HomePage login(Object user , Object pwd){
        username.sendKeys(user.toString());
        password.sendKeys(pwd.toString());
        signIn.click();
        return new HomePage(driver);


    }

    public void loginWithWrongCred(String user , String pwd){
        username.sendKeys(user);
        password.sendKeys(pwd);

        signIn.click();
        Assert.assertEquals("asfcs","gdts");
    }


}
