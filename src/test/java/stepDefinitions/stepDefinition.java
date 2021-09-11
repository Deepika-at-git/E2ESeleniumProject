package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LogInPage;
import resources.Base;

import java.io.IOException;

public class stepDefinition extends Base {

    @Given("^Initialize browser with chrome$")
    public void initialize_browser_with_chrome() throws IOException {
        driver =initializeDriver();

    }

    @And("^Navigate to \"([^\"]*)\" site$")
    public void navigateToSite(String arg0) {

        driver.get(arg0);

    }

    @And("^Click on Login in the home page to land to secure sign in$")
    public void clickOnLoginInTheHomePageToLandToSecureSignIn() {
        LandingPage objL = new LandingPage(driver);
        objL.getLogIn();
    }

    @When("^User enters <username> and <password> and logs in$")
    public void userEntersUsernameAndPasswordAndLogsIn(String username, String password) {
        LogInPage objLogin = new LogInPage(driver);
        objLogin.getemail().sendKeys(username);
        objLogin.getpassword().sendKeys(password);
        objLogin.getlogin().click();
    }

    @Then("^Verify user is not logged in with invalid credentials$")
    public void verifyUserIsNotLoggedInWithInvalidCredentials() {
        LogInPage objLogin = new LogInPage(driver);
        ForgotPassword fp=objLogin.getforgotPassword();
        fp.getemail().sendKeys("abc@abc.com");
        fp.getsendMeInstruction().click();

    }


}
