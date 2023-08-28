package com.qaprosoft.carina.demo.gui.components.solvd;

import com.qaprosoft.carina.demo.gui.components.solvd.enums.FirstMenuLayer;
import com.qaprosoft.carina.demo.gui.components.solvd.enums.SecondMenuLayer;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderMenu extends AbstractUIObject {
    private static final Duration TIMEOUT = Duration.ofSeconds(2);

    @FindBy(xpath = "//div[text()='%s']")
    private ExtendedWebElement firstMenuLinkDiv;

    @FindBy(xpath = "//a[text()='%s']")
    private ExtendedWebElement firstMenuLinkA;

    @FindBy(xpath = "//nav/div/div[2]")
    private ExtendedWebElement secondHeaderLayer;

    @FindBy(xpath = "//span[text()='%s']")
    private ExtendedWebElement secondMenuLink;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickMenuLink(FirstMenuLayer firstLink) {
        firstMenuLinkA.format(firstLink.getText()).click();
    }

    public void clickMenuLink(FirstMenuLayer firstLink, SecondMenuLayer secondLink) {
        firstMenuLinkDiv.format(firstLink.getText()).hover();
        waitForElementToBeDisplayed(secondHeaderLayer);
        secondMenuLink.format(secondLink.getText()).click();
    }

    public void waitForElementToBeDisplayed(ExtendedWebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        ExpectedCondition<Boolean> elementDisplayed = arg0 -> {
            try {
                element.isVisible();
                return true;
            } catch (Exception e) {
                return false;
            }
        };
        wait.until(elementDisplayed);
    }
}
