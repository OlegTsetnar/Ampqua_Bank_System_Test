package com.ampqua.pageUI.pages;

import com.ampqua.pageUI.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivateBankPage extends BasePage {
    public PrivateBankPage(WebDriver driver) {
        super(driver);
    }

    enum Using {
    ;

        private final By selector;

        Using(By selector) {
            this.selector = selector;
        }

        public By selector() {
            return selector;
        }
    }
}
