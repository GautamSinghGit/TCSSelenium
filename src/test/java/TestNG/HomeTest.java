package TestNG;

import Base.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomeTest extends BaseClass {




    String []product = {"ZARA COAT 3","IPHONE 13 PRO"};


    @Test(dataProvider = "getData",groups = {"smoke"})
    public void validateUserIsOnHomePage(String user  , String pwd){
      HomePage homePage = loginPage.login(user, pwd);
        Assert.assertTrue(homePage.logoIsDisplayed());
        homePage.clickOnCartForProducts(product);


    }

    @Test(dataProvider = "getData")
    public void validateProductAddedSuccessfullyDisplayedForSingleProduct(String user  , String pwd){
       HomePage homePage = loginPage.login(user, pwd);
       boolean t = homePage.validateAddCartSuccessfullyMsgIsDisplayed("ZARA COAT 3");
       Assert.assertTrue(t);



    }

    @DataProvider
    public Object[][] getData(){

        Object[][] data = {{"selenium3@gmail.com","Selenium@123"}};
                return data;

    }

}
