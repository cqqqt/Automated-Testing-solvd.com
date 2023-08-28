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

public class ServicesMobilePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final long TIMEOUT = 7;

    @FindBy(xpath = "//header[@aria-label='Primary']/div/div/nav")
    private HeaderMenu headerMenu;

    @FindBy(xpath="//h2[text()='Related success stories']")
    private ExtendedWebElement firstSectionsElem;

    @FindBy(xpath="//h2[contains(@class,'MuiTypography-root MuiTypography-h3')]")
    private List<ExtendedWebElement> listSections;

    public ServicesMobilePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(firstSectionsElem);
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
        openURL(Configuration.getEnvArg("services_mobile_page"));
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public List<String> getListSections() {
        List<String> list = new ArrayList<>();
        for(ExtendedWebElement list1Element : listSections) {
            list.add(list1Element.getText());
        }
        return list;
    }
}