package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

  private static WebDriver driver;

  //  TODO: handle driver more elegantly
  public static WebDriver createChromeDriver() {
    driver = WebDriverManager.chromedriver().create();
    driver.manage().window().maximize();
    return driver;
  }

  public static void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }

}