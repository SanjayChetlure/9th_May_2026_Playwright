package S7_Iframe;
import com.microsoft.playwright.*;


public class Ex1_MouseAction_Hover
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
        page.waitForTimeout(3000);

        // 1: Identify mouse Hover element
        Locator login = page.locator("//span[text()='Login']");

        // 2: Move mouse over Login element
        login.hover();
        page.waitForTimeout(5000);

        // Click on Orders link
        page.locator("//div[text()='Orders']").click();

        page.waitForTimeout(5000);
        browser.close();
        pw.close();
    }
}
