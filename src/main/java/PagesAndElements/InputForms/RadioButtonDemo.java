package PagesAndElements.InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static Utils.Browser.driver;

public class RadioButtonDemo
{
    public static void testSingleRadio()
    {
        WebElement container = driver.findElement(By.xpath("//button[@id=\"buttoncheck\"]/../parent::div"));
        List<WebElement> radioButtons = container.findElements(By.xpath(".//input"));
        WebElement submitButton = driver.findElement(By.xpath(".//button[@id=\"buttoncheck\"]"));
        String textToCheck;
        String[] expectedResult = {"Male", "Female"};
        int i = 0;
        for (WebElement radio : radioButtons)
        {
            radio.click();
            submitButton.click();
            textToCheck = container.findElement(By.xpath(".//p[@class=\"radiobutton\"]")).getText();
            Assert.assertEquals(textToCheck, "Radio button '" + expectedResult[i] + "' is checked","Wrong text for button "+ (i+1));
            i++;
        }
    }
}
