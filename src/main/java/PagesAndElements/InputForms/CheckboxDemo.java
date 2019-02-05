package PagesAndElements.InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;

import static Utils.Browser.driver;

public class CheckboxDemo
{
    public static void testSingleCheckbox()
    {
        WebElement checkboxMain = driver.findElement(By.id("isAgeSelected"));
        WebElement checkboxConfirmText = driver.findElement(By.id("txtAge"));
        String confirmTextAttribute = checkboxConfirmText.getAttribute("style");

        Assert.assertEquals(confirmTextAttribute, "display: none;", "Text shows if checkbox is unchecked");

        checkboxMain.click();
        confirmTextAttribute = checkboxConfirmText.getAttribute("style");
        String[] possibleValues = {"","display: block;"};
        Assert.assertTrue(Arrays.stream(possibleValues).anyMatch(confirmTextAttribute::equals), "Text doesn't show if checkbox is checked");
    }

    
}
