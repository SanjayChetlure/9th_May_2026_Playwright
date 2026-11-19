package S2_PageInterfaceMethods;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Ex3_title
{
    public static void main(String[] args) throws InterruptedException {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

       page.navigate("https://www.google.com");
        String pageTitle = page.title();
        System.out.println("Page Title: " + pageTitle);

        Thread.sleep(5000);

        browser.close();
        pw.close();
    }
}
