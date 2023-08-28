package com.qaprosoft.carina.demo.gui.pages.solvd;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.qaprosoft.carina.demo.gui.components.solvd.HeaderMenu;
import com.zebrunner.carina.utils.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;


public class MainPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private String greenColor = "rgba(2, 204, 103, 1)";
    private static final long TIMEOUT = 7;

    @FindBy(xpath = "//header[@aria-label='Primary']/div/div/nav")
    private HeaderMenu headerMenu;

    @FindBy(xpath = "//div[@class='jss66']/div")
    private ExtendedWebElement firstOurServicesElem;

    @FindBy(xpath = "//section[./h2[text()='Our Services']]/div/div/div[.//h3[text() = '%s']]")
    private ExtendedWebElement service;

    @FindBy(xpath = "//section[./h3[text()='Industries']]/div/div/div[text() = '%s']")
    private ExtendedWebElement industry;

    @FindBy(xpath = "//section[./h2[text()='Our Services']]/div/div/div[.//h3[text() = '%s']]//button[@aria-label=\"See more the content\"]")
    private ExtendedWebElement serviceSeeMore;

    @FindBy(xpath = "//section[./h2[text()='Our Services']]/div/div/div[.//h3[text() = '%s']]//button[@aria-label=\"See less the content\"]")
    private ExtendedWebElement serviceSeeLess;

    @FindBy(xpath = "//section[./h2[text()='Our Services']]/div/div/div[.//h3[text() = '%s']]//div[./ul]")
    private ExtendedWebElement ourServicesDescriptionsNew;

    @FindBy(xpath = "//div[@class='jss95']/div[@role='button']")
    private List<ExtendedWebElement> listIndustries;

    @FindBy(xpath = "//section[./h3[text()='Industries']]//div/p")
    private ExtendedWebElement descriptionOfIndustry;

    public MainPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(firstOurServicesElem);
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
        openURL(Configuration.getEnvArg("base"));
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public void hoverService(String name) {
        service.format(name).hover();
    }

    public void hoverIndustry(String name) {
        industry.format(name).scrollTo();
        industry.format(name).hover();
    }

    public boolean isSeeMoreVisible(String name) {
        return serviceSeeMore.format(name).isVisible(1);
    }

    public void clickSeeMore(String name) {
        serviceSeeMore.format(name).scrollTo();
        serviceSeeMore.format(name).click();
    }

    public void clickSeeLess(String name) {
        serviceSeeLess.format(name).click();
    }

    public Boolean isElementBackgroundGreen(String name) {
        return service.format(name).getElement().getCssValue("background-color").equals(greenColor);
    }

    public boolean isServiceDescVisible(String name) {
        return ourServicesDescriptionsNew.format(name).isVisible(1);
    }

    public boolean isIndustryDescVisible() {
        return descriptionOfIndustry.isVisible(1);
    }

    public String getServiceDescText(String name) {
        return ourServicesDescriptionsNew.format(name).getText();
    }

    public String getIndustryDescText() {
        return descriptionOfIndustry.getText();
    }
}
