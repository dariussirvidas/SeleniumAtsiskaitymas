import org.junit.*;

public class SeleniumTest {
    @BeforeClass
    public static void testSetupChrome() {
        Selenium.setupChrome();
    }
    @AfterClass
    public static void testCloseChrome() {
        Selenium.closeChrome();
    }
    @Test
    public void testAddEntrySuccessful() {
        Selenium.addEntry("test1", "test2", "test3");
        Assert.assertTrue(Selenium.waitByCssSelector("div.msg-good").isDisplayed());
    }
    @Test
    public void testAddEntryFailed() {
        Selenium.addEntry("test1", "test2", "");
        Assert.assertTrue(Selenium.waitByCssSelector("div.msg-bad").isDisplayed());
    }
    @Test
    public void testDeleteEntry() {
        Selenium.deleteEntry(646);
        Assert.assertTrue(Selenium.waitByCssSelector("div.msg-good").isDisplayed());
    }
    @Test
    public void testEditEntrySuccess() {
        Selenium.editEntry(644, "edit11", "edit22", "edit33");
        Assert.assertTrue(Selenium.waitByCssSelector("div.msg-good").isDisplayed());
    }
    @Test
    public void testEditEntryFailed() {
        Selenium.editEntry(645, "edit11", "edit22", "");
        Assert.assertTrue(Selenium.waitByCssSelector("div.msg-bad").isDisplayed());
    }

}
