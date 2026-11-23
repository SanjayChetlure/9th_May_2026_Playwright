package S5_PerformAction_On_InputField_RadioButton_Checboxes_WithAssertion;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Ex1_InputField
{
    public static void main(String[] args) throws InterruptedException {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://testautomationpractice.blogspot.com/");
        Thread.sleep(2000);


        // Clicks on the element with the specified text
        Locator name = page.locator("//input[@id='name']");

        //verify name input field is visible
        PlaywrightAssertions.assertThat(name).isVisible();

        //verify name input field is enabled
        PlaywrightAssertions.assertThat(name).isEnabled();

        //verify name filed has attribute maxlength with value 15
        PlaywrightAssertions.assertThat(name).hasAttribute("maxlength", "15");

        name.fill("abc");

        //verify name input field has value abc
        PlaywrightAssertions.assertThat(name).hasValue("abc1");

        Thread.sleep(3000);
        browser.close();
        pw.close();
    }
}
