package S8_MouseActions;
import com.microsoft.playwright.*;


public class Ex4_MouseDoubleClick
{
    // Handle Alert
    public static void handleAlert(Dialog dialog)
    {
        System.out.println("Alert Message: " + dialog.message());   //get message from alert popup
        dialog.accept();         // Click OK after 2 seconds
    }

    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://demo.guru99.com/test/simple_context_menu.html");
        page.waitForTimeout(3000);

        // Register Alert Handler
        page.onDialog(Ex4_MouseDoubleClick::handleAlert);

        // Identify Double Click button
        Locator element = page.locator("//button[text()='Double-Click Me To See Alert']");

        // Perform Double Click
        element.dblclick();

        page.waitForTimeout(3000);
        browser.close();
        pw.close();
    }
}










//Meaning: Register an alert handler. Whenever a JavaScript alert appears, Playwright automatically calls the handleAlert() method.
//        page.onDialog() – Listens for JavaScript alert popups.
//        Ex1_MouseDoubleClick – Class name.
//        :: – Method reference operator.
//        handleAlert – Method that handles the alert.

//Execution flow:
//  page.dblclick() triggers the alert.
//  page.onDialog() detects the alert.
//  handleAlert() method executes automatically.
//  dialog.message() gets the alert message.
//  dialog.accept() clicks OK.

//Note: We are connecting the alert event with our handleAlert() method so that whenever an alert appears,
// that method executes automatically.
