package TestInputForms;

import PagesAndElements.InputForms.CheckboxDemo;
import Utils.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCheckboxDemo
{
    @BeforeMethod
    public void setup()
    {
        Browser.BrowserSetup("chrome");
        Browser.BrowserOpenUrl("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }


    @Test
    public void testSingleCheckbox()
    {
        CheckboxDemo.testSingleCheckbox();
    }


    @AfterMethod
    public void tearDown()
    {
        Browser.BrowserQuit();
    }
}
