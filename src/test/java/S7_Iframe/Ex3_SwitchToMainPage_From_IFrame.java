package S7_Iframe;
import com.microsoft.playwright.*;


public class Ex3_SwitchToMainPage_From_IFrame
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

        //perform action on main page -> click on home link from main page
        page.locator("(//a[text()='Home'])[1]").click();

        page.waitForTimeout(5000);
        browser.close();
        pw.close();
    }
}
