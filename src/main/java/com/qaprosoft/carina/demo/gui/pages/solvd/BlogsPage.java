package com.qaprosoft.carina.demo.gui.pages.solvd;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.solvd.HeaderMenu;
import com.zebrunner.carina.utils.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class BlogsPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private String greenColor = "rgba(218, 255, 215, 1)";
    private static final long TIMEOUT = 2;

    @FindBy(xpath = "//header[@aria-label='Primary']/div/div/nav")
    private HeaderMenu headerMenu;

    @FindBy(xpath = "//article/div/div[./a]")
    private ExtendedWebElement blogDesc;

    @FindBy(xpath = "//article/div/div/a[text() = '%s']")
    private ExtendedWebElement categoryOfBlog;

    @FindBy(xpath = "//article/div/div/a")
    private List<ExtendedWebElement> listCategoriesOfBlogs;

    @FindBy(xpath = "//article")
    private List<ExtendedWebElement> listBlogs;

    @FindBy(xpath = "//article[%d]//a[text()= '%s']")
    private ExtendedWebElement articleValue;

    @FindBy(xpath = "//main/div/div/a[text()='%s']")
    private ExtendedWebElement categoryNameButton;

    public BlogsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(blogDesc);
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
        openURL(Configuration.getEnvArg("blogs_page"));
    }

    public Boolean isCategoryClicked(String text) {
        return categoryNameButton.format(text).getElement().getCssValue("background-color").equals(greenColor);
    }

    public void clickOnBlockButton(String text) {
        categoryNameButton.format(text).click();
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public int getBlogsCount() {
        return listBlogs.size();
    }

    public boolean isArticleHasCategory(int number, String category) {
        return articleValue.format(number, category).isVisible();
    }
}
