package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.VatCalculatorPage;
import utils.WebDriverFactory;

//TODO: use lombok - add logging projectwide
public class VatCalculatorStepDefinitions {

  private VatCalculatorPage vatCalculatorPage;
  private WebDriver driver;

//  TODO: use hooks to set up and tear down the driver
  @Before
  public void setup() {
    driver = WebDriverFactory.createChromeDriver();
    vatCalculatorPage = new VatCalculatorPage(driver);
  }

  @After
  public void tearDown() {
    if (driver != null) {
      WebDriverFactory.quitDriver();
    }
  }

  @Given("I am on the VAT calculator page")
  public void iAmOnTheVatCalculatorPage() {
    vatCalculatorPage.navigateTo();
  }

  @When("I accept the cookie consent")
  public void iAcceptTheCookieConsent() {
    vatCalculatorPage.acceptCookieConsent();
  }

  @When("I select {string} as the country")
  public void iSelectAsTheCountry(String country) {
    vatCalculatorPage.selectCountry(country);
  }

  @When("I choose {string} as the VAT rate")
  public void iChooseAsTheVatRate(String vatRate) {
    vatCalculatorPage.selectVatRate(vatRate);
  }

  @When("I enter {string} as the Net amount")
  public void iEnterAsTheNetAmount(String amount) {
    vatCalculatorPage.enterNetAmount(amount);
  }

  @Then("the Gross amount should be {string}")
  public void theGrossAmountShouldBe(String expectedGross) {
    assertEquals(expectedGross, vatCalculatorPage.getGrossAmount());
  }

  @Then("the VAT amount should be {string}")
  public void theVatAmountShouldBe(String expectedVat) {
    assertEquals(expectedVat, vatCalculatorPage.getVatAmount());
  }

  @Then("I should see an error message")
  public void iShouldSeeAnErrorMessage() {
    assertTrue(vatCalculatorPage.isErrorMessageDisplayed());
  }

  @And("the error message should contain {string}")
  public void theErrorMessageShouldContain(String expectedText) {
    assertTrue(vatCalculatorPage.getErrorMessageText().contains(expectedText));
  }
}