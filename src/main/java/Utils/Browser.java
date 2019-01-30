package Utils;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Browser
{
    public static WebDriver driver;

    /**
     * Opens a browser instance of the selected browserType
     * @param browserType type of browser you want to be opened (valid options are "Chrome", "Firefox", "Edge"
     */
    public static void BrowserSetup(String browserType)
    {
        switch (browserType.toLowerCase())
        {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "src\\main\\resources\\MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                throw new InvalidArgumentException("driver should be Chrome, Firefox or Edge");

        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * Maximases current browser instance
     */
    public static void BrowserMaximize() {driver.manage().window().maximize();}

    /**
     * Quits current browser instance
     */
    public static void BrowserQuit() {driver.quit();}
}
