package S4_Xpath_And_CSS_Locator;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Ex2_CSS
{
    public static void main(String[] args) throws InterruptedException {

        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://testautomationpractice.blogspot.com");
        Thread.sleep(2000);

        //Enter Name
        page.locator("input#name").fill("abc");

        //Enter Email
        page.locator("input#email").fill("xyz");

        Thread.sleep(15000);

        browser.close();
        pw.close();

    }
}
