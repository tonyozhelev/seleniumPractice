package TestTable;

import PagesAndElements.Table.TablePagination;
import Utils.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTablePagination
{
    @BeforeMethod
    public void setup()
    {
        Browser.BrowserSetup("chrome");
        Browser.BrowserOpenUrl("https://www.seleniumeasy.com/test/table-pagination-demo.html");
    }

    @Test
    public void testTableNavigation()
    {
        TablePagination.checkNavButtons();
    }

    @Test
    public void testTablePagination() {TablePagination.checkElementPagination(5);}

    @AfterMethod
    public void tearDown()
    {
        Browser.BrowserQuit();
    }
}
