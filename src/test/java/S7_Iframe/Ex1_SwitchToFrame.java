package S7_Iframe;

import com.microsoft.playwright.*;

public class Ex1_SwitchToFrame
{
    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://autotestsandbox.com/examples/nested-iframes");

        // Switch to outer frame
        FrameLocator outerFrame = page.frameLocator("//iframe[@title='Outer nested frame']");

        // Get text from outer iframe
        String outerFrameText = outerFrame.locator("//p[text()='Outer iframe']").innerText();

        System.out.println("outerText: " + outerFrameText);

        page.waitForTimeout(2000);
        browser.close();
        pw.close();
    }
}
