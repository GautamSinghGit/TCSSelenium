package StepDefinitions;

import Base.BaseClass;
import Pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeTestStep extends BaseClass {



    @When("user add a single {string} to the cart")
    public void userAddASingleToTheCart(String productname) {



    }

    @Then("user verify success message is displayed")
    public void userVerifySuccessMessageIsDisplayed() {
    }
}
