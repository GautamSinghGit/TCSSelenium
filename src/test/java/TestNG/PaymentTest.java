package TestNG;

import Base.BaseClass;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PaymentPage;
import io.cucumber.java.hu.Ha;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PaymentTest extends BaseClass {

    private WebDriver driver;

    String country = "India";
    String[] products = {"ADIDAS ORIGINAL", "ZARA COAT 3"};

    @DataProvider
    public Object[][] getData() throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("email", "selenium3@gmail.com");
        map.put("pwd", "Selenium@123");


        List<HashMap<String,String>> d = getJsonToMap();
        Object [][]dq = {{d.get(0)}};
        return dq;
    }


    @Test(dataProvider = "getData")
    public void selectCorrectCountry(HashMap<Object, Object> map) throws IOException {
        System.out.println(map.get("products"));
        System.out.println(map.get("email"));
        System.out.println(map.get("pwd"));

        HomePage homePage = loginPage.login(map.get("email"), map.get("pwd"));
        homePage.clickOnCartForProducts(products);
        CartPage cartPage = homePage.clickOnCartButton();
        PaymentPage paymentPage = cartPage.clickOnCheckOutButton();
        paymentPage.selectCountryName(country);





    }
}
