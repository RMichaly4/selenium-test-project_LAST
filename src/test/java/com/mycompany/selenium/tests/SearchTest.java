package com.mycompany.selenium.tests;


import com.mycompany.selenium.TestBase;
import com.mycompany.selenium.enums.Language;
import com.mycompany.selenium.enums.Location;
import com.mycompany.selenium.enums.TimePeriod;
import com.mycompany.selenium.pageobejcts.SearchPage;
import com.mycompany.selenium.pageobejcts.SearchResultPage;
import com.mycompany.selenium.pageobejcts.TopMenuBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SearchTest extends TestBase {
    /**
    TAKEAWAYS:
    * *Page Object* methods should be named as from Business logic perspective, more abstract -
        * avoid naming methods as "clickOnSaveButton()"
        * it helps to make your test more readable and more maintainable
    * Page Object returns some info about the page (e.g. new page object, text from page, a boolean result for some check, etc. -
        * never a WebElement (but there might be some exceptions - like with `searchResultElements`)
    * Put explicit wait into Page Object Constructor
        * in order to wait until page ready state
        * or you can use Loadable Component pattern
    * Repeating actions in multiple Page Objects should be put into separate helper class (as with Select example)
        * Make method static so that there will be no need to initialize an instance
    * Recommended to return other Page Objects in a method which end up going to another page
    * If a method stays on the same page, then return the same Page Object ("return this").
        * This will make your tests more "fluent" (https://en.wikipedia.org/wiki/Fluent_interface)
    * Keep folder structure clean
    *
     */


    @Test
    public void testSearch() throws Exception {
        TopMenuBar topMenuBar = new TopMenuBar(driver);
        SearchPage searchPage = topMenuBar
                .switchLangTo(Language.RU)
                .goToSearch();


        SearchResultPage searchResultPage = searchPage.searchForPhrase("Компьютер")
                .selectSubDivision("Электротехника")
                .selectCategory("Компьютеры, оргтехника")
                .selectLocation(Location.RIGA)
                .selectTimePeriod(TimePeriod.ALL_PERIOD)
                .performSearch();

        assertTrue(searchResultPage.getSearchResultElementsCount() > 0);
        assertTrue(searchResultPage.searchResultElements.get(0).isDisplayed());


    }

}
