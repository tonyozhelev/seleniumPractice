package TestNavigation;

import PagesAndElements.Navigation.NavigationBar;
import Utils.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNavigationMenusOptions
{
    @BeforeMethod
    public void setup()
    {
        Browser.BrowserSetup("chrome");
        Browser.BrowserOpenUrl("https://www.seleniumeasy.com/test/");
    }

    @Test
    public void checkSideMenuOptions()
    {
        NavigationBar.checkSideMenuItems();
    }

    @Test
    public void checkNavBarOptions()
    {
        Browser.BrowserWindowMaximize();
        NavigationBar.checkNavBarItems();
    }

    @AfterMethod
    public void tearDown()
    {
        Browser.BrowserQuit();
    }
}
