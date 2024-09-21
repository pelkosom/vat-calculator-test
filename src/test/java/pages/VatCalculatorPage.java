package pages;

import java.sql.Driver;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.function.ToDoubleBiFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

public class VatCalculatorPage {

  private final WebDriverWait wait;
  private final WebDriver driver;


//  TODO: use best practices to locate all elements - this is just a starting point

  @FindBy(className = "fc-button-label")
  private WebElement cookieConsentButton;

  @FindBy(xpath = "//*[@id=\"vatcalculator\"]/div[2]/div[2]/select")
  private WebElement countryDropdown;

  @FindBy(id = "VAT_20")
  private WebElement vatRateDropdown;

  @FindBy(id = "NetPrice")
  private WebElement netAmountInput;

  @FindBy(id = "gross_amount")
  private WebElement grossAmountInput;

  @FindBy(id = "vat_amount")
  private WebElement vatAmountInput;

  @FindBy(id = "google-visualization-errors-all-5")
  private WebElement errorMessage;


  public VatCalculatorPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 5);
  }

  public void navigateTo() {
    driver.get("http://www.calkoo.com/?lang=3&page=8");
  }

  public void acceptCookieConsent() {
    wait.until(ExpectedConditions.elementToBeClickable(cookieConsentButton));
    cookieConsentButton.click();
  }

  public void selectCountry(String country) {
    wait.until(ExpectedConditions.elementToBeClickable(countryDropdown));
    new Select(countryDropdown).selectByVisibleText(country);
  }

  public void selectVatRate(String vatRate) {
//    TODO
    wait.until(ExpectedConditions.elementToBeClickable(vatRateDropdown));
    vatRateDropdown.click();
  }

  public void enterNetAmount(String amount) {
    netAmountInput.clear();
    netAmountInput.sendKeys(amount);
  }

  public String getGrossAmount() {
    wait.until(ExpectedConditions.visibilityOf(grossAmountInput));
    return grossAmountInput.getAttribute("value");
  }

  public String getVatAmount() {
    wait.until(ExpectedConditions.visibilityOf(vatAmountInput));
    return vatAmountInput.getAttribute("value");
  }

  public boolean isErrorMessageDisplayed() {
    return wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
  }

  public String getErrorMessageText() {
    wait.until(ExpectedConditions.visibilityOf(errorMessage));
    return errorMessage.getText();
  }
}