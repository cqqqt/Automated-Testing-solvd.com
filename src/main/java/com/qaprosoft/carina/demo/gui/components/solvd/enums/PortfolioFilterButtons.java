package com.qaprosoft.carina.demo.gui.components.solvd.enums;

import java.util.Arrays;
import java.util.List;

public enum PortfolioFilterButtons {
    INDUSTRY("Industry", Arrays.asList("Fitness", "Fintech", "E-commerce", "Transportation", "Digital Product", "Health")),
    SERVICE("Service", Arrays.asList("QA", "Test Automation", "Mobile App Development", "Web App Development", "MVP")),
    TECHNOLOGY("Technology", Arrays.asList("Java", "TestNG", "Appium", "Docker", "Swift", "PHP", "Selenium", "AngularJS",
            "React", "Jenkins", "Scala", "Selenoid", "iOS xCode", "Sandbox", "Testflight", "AWS", "Apple SDK", "UIKit"));

    private final String name;
    private final List<String> subcategories;

    PortfolioFilterButtons(String name, List<String> subcategories) {
        this.name = name;
        this.subcategories = subcategories;
    }

    public String getName() {
        return name;
    }

    public List<String> getSubcategories() {
        return subcategories;
    }
}
