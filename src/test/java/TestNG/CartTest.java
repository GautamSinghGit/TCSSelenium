package TestNG;

import Base.BaseClass;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class CartTest extends BaseClass {


    String[] product = {"IPHONE 13 PRO"};



    @Test(dataProvider = "getData")
    public void validateProductsCountAddedIntoCart(String user , String pwd) {
        HomePage homePage =  loginPage.login(user, pwd);
        homePage.clickOnCartForProducts(product);
       CartPage cartPage = homePage.clickOnCartButton();

        List<String> productsCountFromCart = cartPage.validateProductsCountAddedIntoCart();
        Assert.assertEquals(product.length, productsCountFromCart.size());
        Assert.assertEquals(productsCountFromCart, Arrays.asList(product));


    }

    @DataProvider
    public Object[][] getData(){

        Object [][]data  = {{"selenium3@gmail.com","Selenium@123"}};
        return data;

    }





}
