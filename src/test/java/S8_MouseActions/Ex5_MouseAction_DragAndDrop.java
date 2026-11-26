package S8_MouseActions;
import com.microsoft.playwright.*;

public class Ex5_MouseAction_DragAndDrop
{
    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        // Open application
        page.navigate("https://demo.guru99.com/test/drag_drop.html");
        page.waitForTimeout(5000);

        // Identify source element
        Locator src = page.locator("(//a[@class='button button-orange'])[2]");

        // Identify destination element
        Locator dest = page.locator("(//div[@class='ui-widget-content'])[3]");

        // Perform drag and drop
        src.dragTo(dest);
        page.waitForTimeout(5000);

        browser.close();
        pw.close();
    }
}
