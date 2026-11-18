package S1_Setup;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Ex4_LaunchBrowser_Webkit_headedMode
{
    public static void main(String[] args) throws InterruptedException {
        Playwright pw = Playwright.create();             // 1: Launches the Playwright server
        Browser browser = pw.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));        // 2: Launches the Webkit browser in headless mode by default
        Page page = browser.newPage();                   // 3: Creates a new page in the browser

        page.navigate("https://www.google.com");    // 4: Navigates to the specified URL
        Thread.sleep(15000);

        browser.close();                               // 5: Closes the browser
        pw.close();                                    // 6: Closes the Playwright server

    }
}
