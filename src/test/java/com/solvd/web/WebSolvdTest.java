package com.solvd.web;

import com.qaprosoft.carina.demo.gui.components.solvd.enums.*;
import com.qaprosoft.carina.demo.gui.pages.solvd.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class WebSolvdTest implements IAbstractTest {
    @Test()
    public void testMainOurServicesBackground() {
        // Open Solvd main page and verify page is opened
        WebDriver driver = getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        assertTrue(mainPage.isPageOpened(), "Main page is not opened!");
        // Check our services for additional description
        SoftAssert softAssert = new SoftAssert();
        for (OurServicesBlocks value : OurServicesBlocks.values()) {
            mainPage.hoverService(value.getName());
            softAssert.assertTrue(mainPage.isElementBackgroundGreen(value.getName()), "Service element background is not green!");
            if(mainPage.isSeeMoreVisible(value.getName())) {
                softAssert.assertFalse(mainPage.isServiceDescVisible(value.getName()), "Description of service mustn't be visible!");
                mainPage.clickSeeMore(value.getName());
                softAssert.assertTrue(mainPage.isServiceDescVisible(value.getName()), "Description of service must be visible");
                softAssert.assertFalse(mainPage.getServiceDescText(value.getName()).isEmpty(), "Description of service is empty!");
                mainPage.clickSeeLess(value.getName());
                softAssert.assertFalse(mainPage.isServiceDescVisible(value.getName()), "Description of service mustn't be visible!");
            }
        }
        softAssert.assertAll();
    }

    @Test()
    public void testMainIndustriesDescription() {
        // Open Solvd main page and verify page is opened
        WebDriver driver = getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        assertTrue(mainPage.isPageOpened(), "Main page is not opened!");
        // Verify industries description
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(mainPage.isIndustryDescVisible(), "Description of industry mustn't be visible!");
        for (Industry value : Industry.values()) {
            mainPage.hoverIndustry(value.getName());
            softAssert.assertTrue(mainPage.isIndustryDescVisible(), "Description of industry must be visible!");
            softAssert.assertEquals(mainPage.getIndustryDescText(), value.getDescription(), "Description of industry is not correct!");
        }
        softAssert.assertAll();
    }

    @Test()
    public void testPortfolioCategories() {
        // Open Solvd main page and verify page is opened
        WebDriver driver = getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        assertTrue(mainPage.isPageOpened(), "Main page is not opened!");
        //Open Solvd portfolio page and verify page is opened
        mainPage.getHeaderMenu().clickMenuLink(FirstMenuLayer.PORTFOLIO);
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        assertTrue(portfolioPage.isPageOpened(), "Portfolio page is not opened!");
        // Verify subcategories of "Service" category are displayed
        SoftAssert softAssert = new SoftAssert();
        for (PortfolioFilterButtons value : PortfolioFilterButtons.values()) {
            portfolioPage.clickOnCategory(value.getName());
            softAssert.assertTrue(portfolioPage.isSubcategoriesDisplayed(), "Subcategories of category " + value.getName() + " are not visible!");
            softAssert.assertEquals(portfolioPage.getSubcategoriesList(), value.getSubcategories(), "Subcategories of category " + value.getName() + " are not correct!");
        }
        portfolioPage.clickAllButton();
        softAssert.assertTrue(portfolioPage.isAllDisplayed(), "All button must be green!");
        softAssert.assertAll();
    }

    @Test()
    public void testPortfolioShowButtons() {
        // Open Solvd main page and verify page is opened
        WebDriver driver = getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        assertTrue(mainPage.isPageOpened(), "Main page is not opened!");
        // Open Solvd portfolio page and verify page is opened
        mainPage.getHeaderMenu().clickMenuLink(FirstMenuLayer.PORTFOLIO);
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        assertTrue(portfolioPage.isPageOpened(), "Portfolio page is not opened!");
        // Verify all projects are displayed
        int firstProjCount = portfolioPage.getProjCount();
        SoftAssert softAssert = new SoftAssert();
        while(portfolioPage.isSeeMoreVisible()) {
            int secondProjCount = portfolioPage.getProjCount();
            portfolioPage.clickSeeMoreButton();
            int thirdProjCount = portfolioPage.getProjCount();
            softAssert.assertTrue(secondProjCount < thirdProjCount, "See more button is not clicked!");
        }
        // Verify projects from category "All" are hidden
        portfolioPage.clickSeeLessButton();
        int fourthProjCount = portfolioPage.getProjCount();
        softAssert.assertEquals(fourthProjCount, firstProjCount, "See less button is not clicked!");
        softAssert.assertAll();
    }

    @Test()
    public void testServicesMobileSections() {
        // Open Solvd main page and verify page is opened
        WebDriver driver = getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        assertTrue(mainPage.isPageOpened(), "Main page is not opened!");
        //Open Solvd services mobile application development page and verify page is opened
        mainPage.getHeaderMenu().clickMenuLink(FirstMenuLayer.SERVICES, SecondMenuLayer.MOBILE_APPLICATION_DEVELOPMENT);
        ServicesMobilePage servicesMobilePage = new ServicesMobilePage(driver);
        assertTrue(servicesMobilePage.isPageOpened(), "Services mobile page is not opened!");
        // Verify sections text
        List<String> actualSectionsText = servicesMobilePage.getListSections();
        List<String> expectedSectionsText = Arrays.stream(SectionsMobile.values()).map(SectionsMobile::getText).collect(Collectors.toList());
        assertEquals(actualSectionsText, expectedSectionsText, "Section is missing!");
    }

    @Test()
    public void testServicesMVPBlocks() {
        // Open Solvd main page and verify page is opened
        WebDriver driver = getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        assertTrue(mainPage.isPageOpened(), "Main page is not opened!");
        // Open Solvd services mvp page and verify page is opened
        mainPage.getHeaderMenu().clickMenuLink(FirstMenuLayer.SERVICES, SecondMenuLayer.MINIMUM_VIABLE_PRODUCT);
        ServicesMVPPage servicesMVPPage = new ServicesMVPPage(driver);
        assertTrue(servicesMVPPage.isPageOpened(), "Services MVP page is not opened!");
        // Verify texts of blocks are correct
        SoftAssert softAssert = new SoftAssert();
        for (MVPBlocks block : MVPBlocks.values()) {
            servicesMVPPage.clickOnBlockButton(block.getName());
            softAssert.assertEquals(servicesMVPPage.getBlockTextsList(), block.getDescriptions(), "Texts of block are not correct!");
        }
        softAssert.assertAll();
    }

    @Test
    public void testBlogCategories() {
        // Open Solvd main page and verify page is opened
        WebDriver driver = getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        assertTrue(mainPage.isPageOpened(), "Main page is not opened!");
        // Open Solvd blogs page and verify page is opened
        mainPage.getHeaderMenu().clickMenuLink(FirstMenuLayer.BLOG);
        BlogsPage blogsPage = new BlogsPage(driver);
        assertTrue(blogsPage.isPageOpened(), "Blogs page is not opened!");
        // Verify categories are present
        for (BlogCategories value : BlogCategories.values()) {
            blogsPage.clickOnBlockButton(value.getName());
            assertTrue(blogsPage.isCategoryClicked(value.getName()), "Category is not clicked!");
            int blogsCount = blogsPage.getBlogsCount();
            for (int i = 1; i <= blogsCount; i++) {
                assertTrue(blogsPage.isArticleHasCategory(i, value.getName()), "The blog does not have a " + value.getName() + " category.");
            }
        }
    }
}