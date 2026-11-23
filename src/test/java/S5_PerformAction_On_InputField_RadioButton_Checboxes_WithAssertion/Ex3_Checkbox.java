package S5_PerformAction_On_InputField_RadioButton_Checboxes_WithAssertion;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Ex3_Checkbox
{
    public static void main(String[] args) throws InterruptedException {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://testautomationpractice.blogspot.com/");
        Thread.sleep(2000);

        // Locate Sunday checkbox
        Locator sundayCheckbox = page.locator("#sunday");

        // Check visibility & enabled status of checkbox
        PlaywrightAssertions.assertThat(sundayCheckbox).isVisible();
        PlaywrightAssertions.assertThat(sundayCheckbox).isEnabled();

        // Check checkbox should not be selected by default
        PlaywrightAssertions.assertThat(sundayCheckbox).not().isChecked();

        Thread.sleep(2000);

        // Select / check checkbox
        sundayCheckbox.check();

        // Verify checkbox is selected
        PlaywrightAssertions.assertThat(sundayCheckbox).isChecked();
        Thread.sleep(5000);

        browser.close();
        pw.close();

    }
}
