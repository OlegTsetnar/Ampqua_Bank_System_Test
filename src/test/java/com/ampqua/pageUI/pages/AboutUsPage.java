package com.ampqua.pageUI.pages;

import com.ampqua.pageUI.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AboutUsPage extends BasePage {
    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    enum Using {
        TEAM_NAMES(By.xpath("//div[@class='headline-3']"));


        private final By selector;

        Using(By selector) {
            this.selector = selector;
        }

        public By selector() {
            return selector;
        }
    }

    /**
     * get all team names
     */
    public List<String> getNamesOfTeam() {
        List<WebElement> elements = findElements(Using.TEAM_NAMES.selector());
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}



