package PagesAndElements.InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

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
        Assert.assertTrue(Arrays.asList(possibleValues).contains(confirmTextAttribute), "Text doesn't show if checkbox is checked");
    }

    public static void testMultiCheckbox()
    {
        List<WebElement> checkboxesToCheck = driver.findElements(By.xpath("//input[@id=\"check1\"]/parent::div/div[contains(@class,\"checkbox\")]//input"));
        WebElement checkAllButton = driver.findElement(By.id("check1"));

        for (int i = 0; i<4; i++)
        {
            for (int j = 0; j<=i; j++)
            {
                checkboxesToCheck.get(j).click();
            }

            if (i!=3)
            {
            Assert.assertEquals(checkAllButton.getAttribute("value"),
                    "Check All",
                    "button displays wrong message when " + (i+1) + " checkboxes are selected");

            checkAllButton.click();
            }
            Assert.assertEquals(checkAllButton.getAttribute("value"),
                    "Uncheck All",
                    "message doesn't update when all boxes are checked, when " + (i+1) + " checkboxes are selected");

            for (WebElement checkbox : checkboxesToCheck)
            {
                Assert.assertTrue(checkbox.isSelected());
            }

            checkAllButton.click();
            Assert.assertEquals(checkAllButton.getAttribute("value"), "Check All", "message doesn't update when uncheck all is clicked");
        }

    }
}
