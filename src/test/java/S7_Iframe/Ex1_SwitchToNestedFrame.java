package S7_Iframe;
import com.microsoft.playwright.*;


public class Ex1_SwitchToNestedFrame
{
    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://autotestsandbox.com/examples/nested-iframes");

        // Locate Outer iframe (Switch to outer frame)
        FrameLocator outerFrame = page.frameLocator("//iframe[@title='Outer nested frame']");

        // Locate Inner/Nested iframe (Switch to inner frame)
        FrameLocator innerFrame = outerFrame.frameLocator("//iframe[@title='Inner']");

        // Get text from inner iframe
        String innerText = innerFrame.locator("//p[text()='Inner iframe content']").innerText();

        System.out.println("Inner frame text: " + innerText);

        page.waitForTimeout(2000);
        browser.close();
        pw.close();
    }
}
