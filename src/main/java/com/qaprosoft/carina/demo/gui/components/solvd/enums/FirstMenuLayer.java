package com.qaprosoft.carina.demo.gui.components.solvd.enums;

public enum FirstMenuLayer {
    PORTFOLIO("Portfolio"),
    SERVICES("Services"),
    PRODUCTS("Products"),
    COMPANY("Company"),
    INNOVATIONS("Innovations"),
    BLOG("Blog");

    private final String text;

    FirstMenuLayer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
