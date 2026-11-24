package S6_HandlingOfListbox;
import com.microsoft.playwright.*;

public class Ex4_listbox_DeselectAllOption_From_MultiSelectable
{
    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://testautomationpractice.blogspot.com/");
        page.waitForTimeout(2000);

        // Locate Multi-Selectable Listbox
        Locator colors = page.locator("select#colors");

        String[] multipleValue = {"red", "blue", "green"};
        colors.selectOption(multipleValue);
        page.waitForTimeout(3000);

//         1. Deselect all options
        String [] ar = {};
        colors.selectOption(ar);


        page.waitForTimeout(5000);


        browser.close();
        pw.close();
    }
}


