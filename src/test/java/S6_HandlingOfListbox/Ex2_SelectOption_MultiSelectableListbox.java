package S6_HandlingOfListbox;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.SelectOption;
import java.util.List;


public class Ex2_SelectOption_MultiSelectableListbox
{
    public static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://testautomationpractice.blogspot.com/");
        page.waitForTimeout(2000);

        // Locate Multi-Selectable Listbox
        Locator colors = page.locator("#colors");

        // 3 Ways to Select Multiple Options (Text/Label, Value, Index)

//         1. Select multiple options using Text
//         String [] multipleText={"Blue", "Red", "Green"};
//         colors.selectOption(multipleText);
//         page.waitForTimeout(5000);


        // 2. Select multiple options using Value
//         String [] multipleValue={"red", "blue", "green"};
//         colors.selectOption(multipleValue);
//         page.waitForTimeout(4000);


        // 3. Select multiple options using Index -> Index starts from 0
//         Select multiple options using Index (starts from zero)
        SelectOption [] multipleIndex = {   new SelectOption().setIndex(0),
                                            new SelectOption().setIndex(1),
                                            new SelectOption().setIndex(3)
        };
        colors.selectOption(multipleIndex);
        page.waitForTimeout(9000);


        // Close browser
        browser.close();
        pw.close();
    }
}
