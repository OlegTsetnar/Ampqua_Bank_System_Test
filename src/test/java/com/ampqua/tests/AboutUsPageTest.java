package com.ampqua.tests;

import com.ampqua.pageUI.pages.AboutUsPage;
import com.ampqua.pageUI.pages.HomePage;
import com.ampqua.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AboutUsPageTest extends BaseTest{

    final String UMPQUA_URL = ConfigurationReader.getProperty("bankUrl");


    /**
     * Verify Team names
     */
    @Test
    public void verifyTeamNames() {
        driver.get(UMPQUA_URL+"/about-us/");
        AboutUsPage aboutUsPage = new AboutUsPage(driver);
        List<String> expectedNames = Arrays.asList("Cort O'Haver","Tory Nixon","Joel Brandenburg","Sheri Burns",
                "Eve Callahan","Ron Farnsworth","Andrew Ognall","Brian Read","David Shotwell","Lori Smith","Kevin Skinner","Frank Namdar");
        List<String> actualNames = aboutUsPage.getNamesOfTeam();
        Assert.assertTrue(actualNames.containsAll(expectedNames));
    }
}
