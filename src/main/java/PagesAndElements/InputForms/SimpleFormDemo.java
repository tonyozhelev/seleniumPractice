package PagesAndElements.InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.text.DecimalFormat;
import static Utils.Browser.driver;

public class SimpleFormDemo
{
    /**
     * Tests the single box input on the page and matches it with the expected result
     * @param input input which should be entered
     */
    public static void testSubmitSingle(String input)
    {
        WebElement formDiv = driver.findElement(By.xpath("//form[@id=\"get-input\"]/parent::div"));
        formDiv.findElement(By.xpath(".//input")).sendKeys(input);
        formDiv.findElement(By.xpath(".//button")).click();
        String textAppeared = formDiv.findElement(By.xpath(".//div[@id=\"user-message\"]/span")).getText();
        Assert.assertEquals(textAppeared,input);
    }

    /**
     * Tests the multi box sum tool on the page and matches it with the expected result
     * @param input1 input to be enetered in the top box
     * @param input2 input to be enetered in the bottom box
     */
    public static void testSubmitMultiSum(String input1, String input2)
    {
        WebElement formDiv = driver.findElement(By.xpath("//form[@id=\"gettotal\"]/parent::div"));
        formDiv.findElement(By.xpath(".//input[@id=\"sum1\"]")).sendKeys(input1);
        formDiv.findElement(By.xpath(".//input[@id=\"sum2\"]")).sendKeys(input2);
        formDiv.findElement(By.xpath(".//button")).click();
        double inputAsNumber1;
        double inputAsNumber2;
        String expectedResult;
        try
        {
            inputAsNumber1 = Double.parseDouble(input1);
            inputAsNumber2 = Double.parseDouble(input2);
            DecimalFormat format = new DecimalFormat("0.#");
            expectedResult = String.valueOf(format.format(inputAsNumber1+inputAsNumber2));
        }
        catch (Exception e)
        {
            expectedResult = "NaN";
        }
        if (expectedResult.length() > 21)
        {
            expectedResult = String.format("%1.16e",Double.parseDouble(expectedResult));
            expectedResult = removeTrailingZeros(expectedResult);
        }

        String textAppeared = formDiv.findElement(By.xpath(".//div/span")).getText();
        Assert.assertEquals(textAppeared,expectedResult);
    }


    /**
     * removes trailing zero from a number in a scientific notation
     * for example: 2.123000000e+28 becomes 2.123e+28
     * @param expectedResult number which should have it's zeros removed
     * @return number with no trailing zeros
     */
    private static String removeTrailingZeros(String expectedResult)
    {
        StringBuilder newResult = new StringBuilder();
        char[] expectedResultArr = expectedResult.toCharArray();
        boolean removingZeros = false;
        for (int i = expectedResult.length()-1; i>=0; i--)
        {
            if (removingZeros && (expectedResultArr[i] == '0' || expectedResultArr[i] == '.'))
            {
                continue;
            }
            else
            {
                removingZeros = false;
            }

            if (expectedResultArr[i]=='e')
            {
                removingZeros = true;
            }

            newResult.append(expectedResultArr[i]);
        }

        return newResult.reverse().toString();
    }
}
