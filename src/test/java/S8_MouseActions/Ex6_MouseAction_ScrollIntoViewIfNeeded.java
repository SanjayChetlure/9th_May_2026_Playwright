package S8_MouseActions;
import com.microsoft.playwright.*;
public class Ex6_MouseAction_ScrollIntoViewIfNeeded
{
    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        // Open application
        page.navigate("https://testautomationpractice.blogspot.com/");
        page.waitForTimeout(5000);

        // Identify Section 3 element
        Locator section3 = page.locator("//h4[text()='Section 3']");

        // Scroll to Section 3
        section3.scrollIntoViewIfNeeded();

        page.waitForTimeout(5000);
        browser.close();
        pw.close();
    }
}
