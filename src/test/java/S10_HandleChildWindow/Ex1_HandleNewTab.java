package S10_HandleChildWindow;
import com.microsoft.playwright.*;

public class Ex1_HandleNewTab
{
    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch( new BrowserType.LaunchOptions().setHeadless(false) );
        Page page = browser.newPage();

        // Open application
        page.navigate("https://skpatro.github.io/demo/links/");
        page.waitForTimeout(2000);

        // Wait for new tab and click NewTab button
        Page childPage = page.waitForPopup(() ->
        {
            page.locator("//input[@name='NewTab']").click();
        });

        // Wait for child tab to load
        childPage.waitForLoadState();

        // Click Training link from child tab
        childPage.locator("(//span[text()='Training'])[1]").click();

        page.waitForTimeout(8000);

        browser.close();
        pw.close();
    }
}
