package com.qaprosoft.carina.demo.gui.pages.solvd;

import com.qaprosoft.carina.demo.gui.components.solvd.HeaderMenu;
import com.zebrunner.carina.utils.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class PortfolioPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private String greenColor = "rgba(2, 204, 103, 1)";
    private static final long TIMEOUT = 7;

    @FindBy(xpath = "//header[@aria-label='Primary']/div/div/nav")
    private HeaderMenu headerMenu;

    @FindBy(xpath = "//span[text()='%s']")
    private ExtendedWebElement blockNameButton;

    @FindBy(xpath = "//a[@aria-label='Filter All projects']")
    private ExtendedWebElement allButton;

    @FindBy(xpath = "//button[@aria-label='Show more projects']")
    private ExtendedWebElement seeMoreButton;

    @FindBy(xpath = "//button[@aria-label='Show less projects']")
    private ExtendedWebElement seeLessButton;

    @FindBy(xpath = "//section[@aria-label='Our projects']/div/div/a")
    private List<ExtendedWebElement> listProjects;

    @FindBy(xpath = "//section[@aria-label='Projects filter']/div/button")
    private List<ExtendedWebElement> listSubcategories;

    public PortfolioPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(allButton);
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
        openURL(Configuration.getEnvArg("portfolio_page"));
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public void clickOnCategory(String text) {
        blockNameButton.format(text).click();
    }

    public void clickAllButton() {
        allButton.click();
    }

    public void clickSeeLessButton() {
        seeLessButton.click();
    }

    public void clickSeeMoreButton() {
        seeMoreButton.click();
    }

    public int getProjCount() {
        return listProjects.size();
    }

    public Boolean isSubcategoriesDisplayed() {
        for (ExtendedWebElement subcategory : listSubcategories) {
            if(subcategory.isVisible(1)) {
                LOGGER.info("Subcategory " + subcategory.getText() + " is visible");
            } else {
                return false;
            }
        }
        return true;
    }

    public Boolean isAllDisplayed() {
        return allButton.getElement().getCssValue("color").equals(greenColor);
    }

    public List<String> getSubcategoriesList() {
        List<String> listSubcategoriesText = new ArrayList<>();
        for(ExtendedWebElement list1Element : listSubcategories) {
            listSubcategoriesText.add(list1Element.getText());
        }
        return listSubcategoriesText;
    }

    public boolean isSeeMoreVisible() {
        return seeMoreButton.isVisible(1);
    }
}
