package com.qaprosoft.carina.demo.gui.components.solvd.enums;

public enum BlogCategories {
    SOLVD_TALKS("SOLVD TALKS"),
    WEB_DEVELOPMENT("WEB DEVELOPMENT"),
    SOFTWARE_DEVELOPMENT("SOFTWARE DEVELOPMENT"),
    DEVELOPMENT("DEVELOPMENT"),
    MANAGEMENT("MANAGEMENT"),
    INTERVIEW("INTERVIEW"),
    NEWS_OR_EVENTS("NEWS / EVENTS"),
    TEST_AUTOMATION("TEST AUTOMATION"),
    QA("QA"),
    MOBILE_DEVELOPMENT("MOBILE DEVELOPMENT"),
    UI_OR_UX_DESIGN("UI/UX DESIGN");

    private final String name;

    BlogCategories(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
