package S8_MouseActions;
import com.microsoft.playwright.*;
public class Ex2_HandleMultipleWindows
{
    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch( new BrowserType.LaunchOptions().setHeadless(false) );
        Page page = browser.newPage();

        // Open main page
        page.navigate("https://skpatro.github.io/demo/links/");
        page.waitForTimeout(2000);

        // 1: Click NewTab and get Child Tab 1
        Page childPage1 = page.waitForPopup(() ->
        {
            page.locator("//input[@name='NewTab']").click();
        });

        childPage1.waitForLoadState();

        // Click Training link from Child Tab 1
        childPage1.locator("(//span[text()='Training'])[1]").click();
        page.waitForTimeout(3000);

        // 2: Main page is already available in 'page' reference

        // 3: Click NewWindow from main page and get Child Window 2
        Page childPage2 = page.waitForPopup(() ->
        {
            page.locator("//input[@name='NewWindow']").click();
        });

        childPage2.waitForLoadState();
        page.waitForTimeout(3000);

        // 4: Close Child Window 2
        childPage2.close();
        page.waitForTimeout(3000);

        // Close Child Tab 1
        childPage1.close();
        page.waitForTimeout(3000);

        // Close Main Page
        page.close();
        browser.close();
        pw.close();
    }
}
