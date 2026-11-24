package S6_HandlingOfListbox;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.SelectOption;
import java.util.List;


public class Ex1_SelectOption_From_SingleSelectableListbox
{
    public static void main(String[] args)
    {

        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://testautomationpractice.blogspot.com/");
        page.waitForTimeout(5000);

        Locator country = page.locator("#country");

        // 3 ways to select option (Text, value, index)

        // 1.1 Select option using VisibleText
        country.selectOption("France");
        page.waitForTimeout(2000);

        // 1.2 Select option using value
        country.selectOption("india");
        page.waitForTimeout(2000);

        // 1.3 Select option using Index (starts with zero)
        SelectOption s=new SelectOption();
        country.selectOption(s.setIndex(1));    //Canada
//        country.selectOption(new SelectOption().setIndex(1));

        page.waitForTimeout(2000);

        // 2. Count total number of options
        Locator allOptions = page.locator("#country > option");

        int cnt = allOptions.count();
        System.out.println("Total options: " + cnt);

        //verify country listbox has total 10 options
        PlaywrightAssertions.assertThat(allOptions).hasCount(10);

        System.out.println("---------");

        // 3. Print all options text
        List<String> allOptionsText = allOptions.allTextContents();
        for (String eachOptionText : allOptionsText)
        {
            System.out.println(eachOptionText.trim());
        }

        page.waitForTimeout(2000);
        browser.close();
        pw.close();

    }
}
