package TestNG;

import Base.BaseClass;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test(dataProvider = "getData",groups = {"smoke"})
    public void validateLogin(String user , String pwd){
        loginPage.login(user, pwd);
    }


    @Test(groups = {"smoke"})
    public void loginWithWrongCredentials(){
        loginPage.loginWithWrongCred("WrongUsername","WrongPassword");


    }

    @DataProvider
    public static Object[][] getData() {
        return new Object[][]{{"selenium3@gmail.com","Selenium@123"}};
    }



}
