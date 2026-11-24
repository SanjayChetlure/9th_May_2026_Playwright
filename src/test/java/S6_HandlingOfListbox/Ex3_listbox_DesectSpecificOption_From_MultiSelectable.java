package S6_HandlingOfListbox;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

public class Ex3_listbox_DesectSpecificOption_From_MultiSelectable
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

        //Select options
        String [] multipleValue={"red", "blue", "green"};
        colors.selectOption(multipleValue);
        page.waitForTimeout(4000);


        // 1. Deselect specific option using Label / Text
//         Keep only Red and Blue selected
//        String [] ar2={"Red", "Blue"};
//        colors.selectOption(ar2);
//        page.waitForTimeout(3000);


        // 2. Deselect specific option using Value
        // Keep only Blue and Green selected
//        String[] ar={"blue", "green"};
//        colors.selectOption(ar);
//        page.waitForTimeout(3000);


        // 3. Deselect specific option using Index
        // Keep only options at index 0 and 1 selected
        SelectOption [] multipleIndex = {
                                        new SelectOption().setIndex(0),
                                        new SelectOption().setIndex(1)
        };
        colors.selectOption(multipleIndex);
        page.waitForTimeout(3000);


        // Close browser
        browser.close();
        pw.close();
    }
}


