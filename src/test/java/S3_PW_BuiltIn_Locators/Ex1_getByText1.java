package S3_PW_BuiltIn_Locators;
import com.microsoft.playwright.*;

public class Ex1_getByText1
{
    public static void main(String[] args) throws InterruptedException {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://testautomationpractice.blogspot.com/p/playwrightpractice.html");
        Thread.sleep(2000);

//        Locator onlineTrainingEle = page.getByText("Online Trainings");
//        onlineTrainingEle.click();

        page.getByText("Online Trainings").click();


        Thread.sleep(15000);

        browser.close();
        pw.close();

    }
}
