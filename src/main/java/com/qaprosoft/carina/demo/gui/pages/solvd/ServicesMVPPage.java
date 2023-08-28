package com.qaprosoft.carina.demo.gui.pages.solvd;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.carina.demo.gui.components.solvd.HeaderMenu;
import com.zebrunner.carina.utils.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServicesMVPPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final long TIMEOUT = 7;

    @FindBy(xpath = "//header[@aria-label='Primary']/div/div/nav")
    private HeaderMenu headerMenu;

    @FindBy(xpath="//main[@aria-label='Content']/article/div/div/div/div/div")
    private ExtendedWebElement firstBlockTextsElem;

    @FindBy(xpath="//main[@aria-label='Content']/article/div/div/div/div/div")
    private List<ExtendedWebElement> listBlockTexts;

    @FindBy(xpath = "//main[@aria-label='Content']/article/div/ul/div/li/div/div[text()='%s']")
    private ExtendedWebElement blockNameButton;

    public ServicesMVPPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(firstBlockTextsElem);
    }

    public boolean isPageOpened() {
        LOGGER.info("Verify page is opened...");
        if (this.uiLoadedMarker != null) {
            return this.uiLoadedMarker.isElementPresent(TIMEOUT);
        } else {
            return false;
        }
    }

    public void open() {
        LOGGER.info("Opening page...");
        openURL(Configuration.getEnvArg("services_mvp_page"));
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public void clickOnBlockButton(String text) {
        blockNameButton.format(text).click();
    }

    public List<String> getBlockTextsList() {
        List<String> listBlockTextNew = new ArrayList<>();
        for(ExtendedWebElement list1Element : listBlockTexts) {
            listBlockTextNew.add(list1Element.getText());
        }
        return listBlockTextNew;
    }
}