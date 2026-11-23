package S5_PerformAction_On_InputField_RadioButton_Checboxes_WithAssertion;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Ex2_RadioButton
{
    public static void main(String[] args) throws InterruptedException {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://testautomationpractice.blogspot.com/");
        Thread.sleep(2000);

        Locator maleRadioBtn = page.locator("#male");

        // Check visibility & enabled status of radio button
        PlaywrightAssertions.assertThat(maleRadioBtn).isVisible();
        PlaywrightAssertions.assertThat(maleRadioBtn).isEnabled();

        // Check radio button should not be selected by default
        PlaywrightAssertions.assertThat(maleRadioBtn).not().isChecked();
        Thread.sleep(2000);

        // Select / check radio button
        maleRadioBtn.check();

        // Verify radio button is selected
        PlaywrightAssertions.assertThat(maleRadioBtn).isChecked();

        Thread.sleep(3000);
        browser.close();
        pw.close();



    }
}
