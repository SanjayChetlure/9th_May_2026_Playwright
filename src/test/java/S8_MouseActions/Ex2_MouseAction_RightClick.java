package S8_MouseActions;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.MouseButton;


public class Ex2_MouseAction_RightClick
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

//        ClickOptions is a static nested class inside the Locator interface.
        Locator.ClickOptions s1 = new Locator.ClickOptions();
        cart.click(s1.setButton(MouseButton.RIGHT));

        page.waitForTimeout(5000);
        browser.close();
        pw.close();
    }
}
