package com.qaprosoft.carina.demo.gui.components.solvd.enums;

public enum SectionsMobile {
    WE_WILL_DO_IT_RIGHT("We’ll do It right"),
    MOBILE_DEVELOPMENT_IN_DETAIL("Mobile development in detail"),
    CHOOSE_YOUR_SERVICE_MODEL("Choose your service model"),
    TOOLS_WE_MASTERED("Tools we mastered"),
    WHAT_OUR_CLIENTS_SAY_ABOUT_US("What our clients say about us"),
    OUR_CLIENTS("Our clients"),
    BUSINESS_DOMAINS_OF_OUR_EXPERTISE("Business domains of our expertise"),
    RELATED_SUCCESS_STORIES("Related success stories");

    private String text;

    SectionsMobile(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}