package com.qaprosoft.carina.demo.gui.components.solvd.enums;

public enum SecondMenuLayer {
    SOFTWARE_WEB_DEVELOPMENT("Software Web Development"),
    MOBILE_APPLICATION_DEVELOPMENT("Mobile Application Development"),
    MINIMUM_VIABLE_PRODUCT("Minimum Viable Product"),
    SOFTWARE_QA_AND_TEST_AUTOMATION_CONSULTING("Software QA & Test Automation Consulting"),
    SOFTWARE_QUALITY_ASSURANCE_AND_TESTING("Software Quality Assurance & Testing"),
    VR_OR_AR_DEVELOPMENT("VR / AR Development"),
    DEV_OPS("DevOps"),
    MCLOUD_PRIVATE_INFRASTRUCTURE("MCloud Private Infrastructure"),
    ZEBRUNNER("Zebrunner"),
    COURSES_IN_ARGENTINA_AND_USA("Courses in Argentina and USA"),
    OPEN_POSITION("Open position"),
    ABOUT_US("About us");

    private String text;

    SecondMenuLayer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
