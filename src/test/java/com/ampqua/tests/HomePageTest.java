package com.ampqua.tests;

import com.ampqua.pageUI.pages.HomePage;
import com.ampqua.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HomePageTest extends BaseTest {

    final String UMPQUA_URL = ConfigurationReader.getProperty("bankUrl");

    /**
     * Verify Broken URL links
     */
    @Test
    public void verifyBrokenUrlLinks() {
        driver.get(UMPQUA_URL);
        HomePage homePage = new HomePage(driver);
        String url = "";
        int RESPONSE_CODE_EXPECTED = 200;
        HttpURLConnection connect = null;
        List<WebElement> links = homePage.getAllLinksWebElements();
        Iterator<WebElement> iterator = links.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getAttribute("href");
            if (url == null || url.isEmpty()) {
                continue;
            }
            if (!url.startsWith(UMPQUA_URL)) {
                continue;
            }
            try {
                connect = (HttpURLConnection) (new URL(url).openConnection());
                connect.setRequestMethod("HEAD");

                int responseCodeActual = connect.getResponseCode();
                Assert.assertTrue(responseCodeActual < 404, "Invalid link: " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Verify Navigator links texts, url, title
     */
    @Test
    public void verifyNavigatorLinksUrlTitle() {
        final String expectedUrl = UMPQUA_URL;
        final String expectedTitle = "Umpqua Bank: Together for better";
        final List<String> expectedNavigatorLinksTexts = Arrays.asList("Personal", "Business", "Commercial",
                "Private Bank", "About Us");
        driver.get(UMPQUA_URL);
        HomePage homePage = new HomePage(driver);
        String actualTitle = homePage.getPageTitle();
        String actualUrl = homePage.getCurrentUrl();
        Assert.assertEquals(expectedTitle, actualTitle);
        Assert.assertEquals(expectedUrl, actualUrl);
        List<String> navigatorLinksTexts = homePage.getNavigatorLinksTexts();
        Assert.assertTrue(navigatorLinksTexts.containsAll(expectedNavigatorLinksTexts));
    }
}

