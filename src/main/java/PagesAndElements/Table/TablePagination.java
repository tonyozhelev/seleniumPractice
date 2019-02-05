package PagesAndElements.Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static Utils.Browser.driver;

public class TablePagination
{
    /**
     * Method that checks if the previous and next page buttons are correctly displayed
     */
    public static void checkNavButtons()
    {
        WebElement[] pages = driver.findElements(By.xpath("//ul[@id=\"myPager\"]/li/a")).toArray(new WebElement[0]);
        for (int i = 1; i < pages.length - 2; i++)
        {
            pages[i].click();
            boolean leftNavButtonHidden = pages[0].getAttribute("style").contains("display: none");
            boolean rightNavButtonHidden = pages[pages.length - 1].getAttribute("style").contains("display: none");
            //first element is previous button
            if (i == 1)
            {
                Assert.assertTrue(leftNavButtonHidden, "problem with element " + i);
            }
            //last element is at length-1 and it is the next button
            else if (i == pages.length - 2)
            {
                Assert.assertTrue(rightNavButtonHidden, "problem with element " + i);
            } else
            {
                Assert.assertTrue(!leftNavButtonHidden && !rightNavButtonHidden, "problem with element " + i);
            }
        }
    }


    /**
     * Check if correct number of elements are shown on each page
     * @param elementsOnPage - number of elemets that should be shown on each page
     */
    public static void checkElementPagination(int elementsOnPage)
    {
        WebElement[] tableRows = driver.findElements(By.xpath("//tbody/tr")).toArray(new WebElement[0]);
        WebElement[] pages = driver.findElements(By.xpath("//ul[@id=\"myPager\"]/li/a")).toArray(new WebElement[0]);

        for (int i = 1; i < pages.length - 2; i++)
        {
            pages[i].click();
            int counter = 0;
            for (WebElement row : tableRows)
            {
                if (counter >= (i - 1) * elementsOnPage && counter < i * elementsOnPage)
                {
                    Assert.assertTrue(!tableRows[counter].getAttribute("style").contains("display: none"),
                            "problem with row " + counter + " on page " + i + " (should be displayed)");
                }
                else
                {
                    Assert.assertTrue(tableRows[counter].getAttribute("style").contains("display: none"),
                            "problem with row " + counter + " one page " + i + " (shoud not be displayed)");
                }
                counter++;
            }
        }
    }

    //TODO: implement method
    public static void checkTableContent()
    {
        throw new NotImplementedException();
    }
}
