package TestInputForms;



import PagesAndElements.InputForms.SimpleFormDemo;
import Utils.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSimpleFormDemo
{
    @BeforeMethod
    public void setup()
    {
        Browser.BrowserSetup("chrome");
        Browser.BrowserOpenUrl("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        Browser.BrowserWindowMaximize();
    }

    @Test
    public void testInputForm1_1(){
        SimpleFormDemo.testSubmitSingle("test input");}
    @Test
    public void testInputForm1_2(){
        SimpleFormDemo.testSubmitSingle("       test input");}
    @Test
    public void testInputForm1_3(){
        SimpleFormDemo.testSubmitSingle("test        input");}

    @Test
    public void testInputForm2_1(){
        SimpleFormDemo.testSubmitMultiSum("1","2");}
    @Test
    public void testInputForm2_2(){
        SimpleFormDemo.testSubmitMultiSum("a","2");}
    @Test
    public void testInputForm2_3(){
        SimpleFormDemo.testSubmitMultiSum("1a","2");}
    @Test
    public void testInputForm2_4(){
        SimpleFormDemo.testSubmitMultiSum("1.1","2");}
    @Test
    //this test should be failing
    public void testInputForm2_5(){
        SimpleFormDemo.testSubmitMultiSum("12345678901234567","12345678901234567");}
    @Test
    public void testInputForm2_6(){
        SimpleFormDemo.testSubmitMultiSum("1234567890123456789012","1234567890123456789012");}
    @Test
    public void testInputForm2_7(){
        SimpleFormDemo.testSubmitMultiSum(
            "99999999999999999999999999999999999999999999999999",
            "99999999999999999999999999999999999999999999999999");}
    @Test
    public void testInputForm2_8(){
        SimpleFormDemo.testSubmitMultiSum(" "," ");}
    @Test
    public void testInputForm2_9(){
        SimpleFormDemo.testSubmitMultiSum("    1"," ");}
    @Test
    public void testInputForm2_10(){
        SimpleFormDemo.testSubmitMultiSum("    2","    3");}


    @AfterMethod
    public void tearDown()
    {
        Browser.BrowserQuit();
    }
}
