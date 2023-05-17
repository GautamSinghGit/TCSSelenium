package StepDefinitions;

import Base.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginTestStep extends BaseClass {

    public LoginPage loginPage;
    public HomePage homePage;



    @Given(": Launch the application")
    public void launchTheApplication() {
        loginPage = launchApplication();
    }

    @Given("user login with {string} and {string}")
    public void userLoginWithAndPwd(String name, String pwd) {
        homePage = loginPage.login(name, pwd);
    }

    @Then("user verify logo is displayed")
    public void userVerifyLogoIsDisplayed() {
        Assert.assertTrue(homePage.logoIsDisplayed());
    }




}
