package S9_HandleAlertPopup;
import com.microsoft.playwright.*;

public class Ex1_HandleAlerts
{
    // Handle Alert
    public static void handleAlert(Dialog dialog)
    {
        System.out.println("Alert Message: " + dialog.message());

        dialog.accept();    // Click OK
//         dialog.dismiss(); // Click Cancel
    }

    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        // Open application
        page.navigate("https://demo.guru99.com/test/delete_customer.php");
        page.waitForTimeout(3000);

        // Enter customer ID
        page.locator("//input[@name='cusid']").fill("123");

        // Register Alert Handler
        page.onDialog(Ex1_HandleAlerts::handleAlert);

        // Click on Submit button
        page.locator("//input[@name='submit']").click();

        page.waitForTimeout(8000);
        browser.close();
        pw.close();
    }
}

