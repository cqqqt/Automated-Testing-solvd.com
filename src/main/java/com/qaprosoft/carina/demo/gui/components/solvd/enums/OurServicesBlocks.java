package com.qaprosoft.carina.demo.gui.components.solvd.enums;

public enum OurServicesBlocks {
    CUSTOM_SOFTWARE_DEVELOPMENT("Custom Software Development"),
    TECHNOLOGY_ADVISORY("Technology Advisory"),
    TECHNOLOGY_CONSULTING("Technology Consulting"),
    DIGITAL_TRANSFORMATION("Digital Transformation"),
    MANAGED_IT_SERVICES("Managed IT Services"),
    MODERNIZATION("Modernization");

    private final String name;

    OurServicesBlocks(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}