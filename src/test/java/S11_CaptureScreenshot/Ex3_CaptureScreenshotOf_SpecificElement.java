package S11_CaptureScreenshot;
import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class Ex3_CaptureScreenshotOf_SpecificElement
{
    public static void main(String[] args)
    {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();
        page.navigate("https://testautomationpractice.blogspot.com/");

        // Capture screenshot of a specific element
        Locator element = page.locator("//button[text()='START']");
        Locator.ScreenshotOptions so = new Locator.ScreenshotOptions();
        element.screenshot(so.setPath(Paths.get("C:\\Users\\sanja\\IdeaProjects\\9th May 2026 Playwright\\Screenshots\\Sample3.png")));

        browser.close();
        playwright.close();
    }
}
