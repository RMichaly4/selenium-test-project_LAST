package com.mycompany.selenium.tests;

import com.mycompany.selenium.TestBase;
import com.mycompany.selenium.pageobejcts.TopMenuBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.mycompany.selenium.enums.Language.LV;
import static com.mycompany.selenium.enums.Language.RU;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class LanguageTest extends TestBase{
    private TopMenuBar topMenuBar;


    @Test
    public void testInitialLanguage() throws Exception {
        //Arrange
        topMenuBar = new TopMenuBar(driver);

        //Assert
        assertEquals("SLUDINĀJUMI", topMenuBar.getPageHeaderHeadText());
    }

    @Test
    public void testSwitchingLanguageToRu() throws Exception {
        //Arrange
        topMenuBar = new TopMenuBar(driver);


        //Act
        topMenuBar.switchLangTo(RU);

        //Assert
        assertEquals("ОБЪЯВЛЕНИЯ", topMenuBar.getPageHeaderHeadText());
    }

    @Test
    public void testSwitchingLanguageToLv() throws Exception {
        //Arrange

        topMenuBar = new TopMenuBar(driver);

        //Act
        topMenuBar.switchLangTo(RU);
        topMenuBar.switchLangTo(LV);

        //Assert
        assertEquals("SLUDINĀJUMI", topMenuBar.getPageHeaderHeadText());
        //assertTrue(false);
    }
}
