package S3_PW_BuiltIn_Locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Ex4_getByTestId
{
    public static void main(String[] args) throws InterruptedException {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://testautomationpractice.blogspot.com/p/playwrightpractice.html");
        Thread.sleep(2000);

        String profileName = page.getByTestId("profile-name").textContent();
        System.out.println("Profile Name " + profileName);

        String profileEmail = page.getByTestId("profile-email").textContent();
        System.out.println("Profile Email: " + profileEmail);

        Thread.sleep(5000);

        browser.close();
        pw.close();

    }
}
