package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

  private static WebDriver driver;

//  TODO: singleton pattern and handle driver more elegantly
  public static WebDriver createChromeDriver() {
    WebDriverManager.chromedriver().setup();

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");

//    TODO: create configuration file to set all options
//    options.addArguments("--headless"); // Run in headless mode, comment out if you want to see the browser

    WebDriver driver = new ChromeDriver(options);
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