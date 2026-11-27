package S11_CaptureScreenshot;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Paths;

public class Ex1_CaptureScreenshotOf_CompleteWebpage
{
    public static void main(String[] args)
    {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://testautomationpractice.blogspot.com/");


        // Capture complete webpage screenshot
        Page.ScreenshotOptions so = new Page.ScreenshotOptions();
        page.screenshot(so.setPath(Paths.get("C:\\Users\\sanja\\IdeaProjects\\9th May 2026 Playwright\\Screenshots\\Sample1.png")).setFullPage(true));


        browser.close();
        playwright.close();
    }
}
