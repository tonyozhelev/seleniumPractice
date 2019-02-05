package PagesAndElements.Navigation;

import org.openqa.selenium.By;
import org.testng.Assert;
import java.io.IOException;
import static Utils.Browser.driver;
import static Utils.FileUtils.getTestData;

public class NavigationBar
{



    /**
     * Method to check item menu at the side of the page.
     * Opens each category and checks it's title and subcategories. Also checks if links are correct.
     * Uses .csv file formated as follows <category>,<subcategory>,<url>
     */
    public static void checkSideMenuItems()
    {
        String[][] valuesToCheck = new String[0][];
        try
        {
            valuesToCheck = getTestData("menuItems.csv");
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        String categoryFlag = valuesToCheck[0][0];
        int categoryCounter = 1;
        int menuCounter = 1;
        boolean isOpened = false;

        for (String[] value:valuesToCheck)
        {
            if (!value[0].equals(categoryFlag))
            {
                isOpened = false;
                menuCounter++;
                categoryCounter = 1;
                categoryFlag = value[0];
            }

            String menuCategory = driver
                    .findElement(By.xpath("//ul[@id=\"treemenu\"]/li/ul/li[" + menuCounter + "]/a"))
                    .getText();
            //open category options
            if (!isOpened)
            {
                driver.findElement(By.xpath("//ul[@id=\"treemenu\"]/li/ul/li[" + menuCounter + "]/a")).click();
                isOpened = true;
            }
            String menuItem = driver
                    .findElement(By.xpath("//ul[@id=\"treemenu\"]/li/ul/li[" + menuCounter + "]/ul/li[" + categoryCounter + "]"))
                    .getText();
            String menuItemUrl = driver
                    .findElement(By.xpath("//ul[@id=\"treemenu\"]/li/ul/li[" + menuCounter + "]/ul/li[" + categoryCounter + "]/a"))
                    .getAttribute("href");

            categoryCounter++;
            Assert.assertEquals(menuCategory,value[0]);
            Assert.assertEquals(menuItem,value[1]);
            Assert.assertEquals(menuItemUrl,value[2]);
        }

        int itemsCount = driver.findElements(By.xpath("//ul[@id=\"treemenu\"]/li/ul/li/ul/li")).size();
        Assert.assertEquals(itemsCount,valuesToCheck.length,"Options count doesn't match!");
    }


    /**
     * Method to check item menu at the navigation bar at the top of the page.
     * the <midSplitCount> variable marks first list after middle of the navbar, since the menu is split in two sections
     * Opens each category and checks it's title and subcategories. Also checks if links are corrects.
     * Uses .csv file formated as follows <category>,<subcategory>,<url>
     */
    public static void checkNavBarItems()
    {
        String[][] valuesToCheck = new String[0][];
        try
        {
            valuesToCheck = getTestData("menuItemsNavBar.csv");
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        String categoryFlag = valuesToCheck[0][0];
        int categoryCounter = 1;
        int menuCounter = 1;
        int midSplitCount = 1;
        int ulSide = 1;
        boolean isOpened = false;

        for (String[] value:valuesToCheck)
        {

            if (!value[0].equals(categoryFlag))
            {
                isOpened = false;
                menuCounter++;
                midSplitCount++;
                categoryCounter = 1;
                categoryFlag = value[0];
            }

            //go to right ul section
            if (midSplitCount == 4)
            {
                ulSide = 2;
                menuCounter = 1;
            }

            String menuCategory = driver
                    .findElement(By.xpath("//ul[contains(@class,\"nav\")][" + ulSide + "]/li[" + menuCounter + "]/a"))
                    .getText();
            //open category options
            if (!isOpened)
            {
                driver.findElement(By.xpath("//ul[contains(@class,\"nav\")][" + ulSide + "]/li[" + menuCounter + "]/a")).click();
                isOpened = true;
            }

            String menuItem = driver
                    .findElement(By.xpath("//ul[contains(@class,\"nav\")][" + ulSide + "]/li[" + menuCounter + "]/ul/li[" + categoryCounter + "]/a"))
                    .getText();
            String menuItemUrl = driver
                    .findElement(By.xpath("//ul[contains(@class,\"nav\")][" + ulSide + "]/li[" + menuCounter + "]/ul/li[" + categoryCounter + "]/a"))
                    .getAttribute("href");

            categoryCounter++;

            Assert.assertEquals(menuCategory,value[0]);
            Assert.assertEquals(menuItem,value[1]);
            Assert.assertEquals(menuItemUrl,value[2]);
        }

        int itemsCount = driver.findElements(By.xpath("//nav//ul/li/ul/li")).size();
        Assert.assertEquals(itemsCount,valuesToCheck.length,"Options count doesn't match!");
    }
}
