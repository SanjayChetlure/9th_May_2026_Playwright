package S8_MouseActions;
import com.microsoft.playwright.*;
public class Ex7_MouseAction_ScrollByPixel
{
    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        // Open application
        page.navigate("https://testautomationpractice.blogspot.com/");
        page.waitForTimeout(2000);

        // Scroll down (Positive Y value)
        page.mouse().wheel(0, 700);
        page.waitForTimeout(5000);

        // Scroll up (Negative Y value)
        page.mouse().wheel(0, -300);
        page.waitForTimeout(5000);

        // Scroll right (Positive X value)
        // page.mouse().wheel(100, 0);

        // Scroll left (Negative X value)
        // page.mouse().wheel(-100, 0);

        browser.close();
        pw.close();
    }
}
