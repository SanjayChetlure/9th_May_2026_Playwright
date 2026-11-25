package S8_MouseActions;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.MouseButton;

public class Ex3_MouseAction_LeftClick
{
    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        // Open Flipkart application
        page.navigate("https://www.flipkart.com/");
        page.waitForTimeout(5000);

        // Click on Close button
        page.locator("//span[@class='b3wTlE']").click();

        page.waitForTimeout(1000);

        // Identify Cart element
        Locator cart = page.locator("//span[text()='Cart']");

        // Left click on Cart element (By default)
        cart.click();

        page.waitForTimeout(5000);
        browser.close();
        pw.close();
    }
}
