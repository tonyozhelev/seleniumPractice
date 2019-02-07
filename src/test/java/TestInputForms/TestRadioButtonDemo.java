package TestInputForms;

import PagesAndElements.InputForms.RadioButtonDemo;
import Utils.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRadioButtonDemo
{
    @BeforeMethod
    public void setup()
    {
        Browser.BrowserSetup("chrome");
        Browser.BrowserOpenUrl("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
    }

    @Test
    public void testRadioSingle()
    {
        RadioButtonDemo.testSingleRadio();
    }

    @AfterMethod
    public void tearDown()
    {
        Browser.BrowserQuit();
    }
}
