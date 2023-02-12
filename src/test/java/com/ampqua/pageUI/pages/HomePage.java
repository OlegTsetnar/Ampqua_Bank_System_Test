package com.ampqua.pageUI.pages;

import com.ampqua.pageUI.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    enum Using {
        LINKS(By.tagName("a")),
        NAVIGATOR_LINKS(By.cssSelector("[class='navigation-block-desktop-menu-bar-item']"));




        private final By selector;

        Using(By selector) {
            this.selector = selector;
        }

        public By selector() {
            return selector;
        }
    }

    /**
     * get all Links WebElements
     */
    public List<WebElement> getAllLinksWebElements() {
        return findElements(Using.LINKS.selector());
    }

    /**
     * get navigator links texts
     */
    public List<String> getNavigatorLinksTexts(){
        List<WebElement> elements = findElements(Using.NAVIGATOR_LINKS.selector());
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }



}
