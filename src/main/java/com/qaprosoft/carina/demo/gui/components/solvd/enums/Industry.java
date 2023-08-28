package com.qaprosoft.carina.demo.gui.components.solvd.enums;

public enum Industry {
    BANKING_AND_FINANCE("Banking and Finance", "Solvd assists banks and financial institutions by offering full-cycle application " +
            "development services. We build applications that add valuable business features, " +
            "facilitate collaboration between departments, enable detection and mitigation " +
            "of security vulnerabilities, and help improve client services."),
    RETAIL_AND_DISTRIBUTION("Retail and Distribution", "Retail software development services by Solvd engineers permit owners of " +
            "retail and supply chain businesses to receive responsive e-commerce web applications, warehouse " +
            "management systems, automated document management, and data analytics solutions. " +
            "Our professionals also apply the DevOps approach and CI/CD pipeline implementation to " +
            "better manage retail software infrastructure."),
    MEDIA_AND_ENTERTAINMENT("Media and Entertainment", "We help clients engage audiences with personalized digital experiences. " +
            "We provide on demand and scalable software solutions to enrich audience journeys, " +
            "build VR/AR solutions that enable an immersive experience, and develop cost efficient " +
            "cloud based systems."),
    LOGISTICS_AND_TRANSPORTATION("Logistics and Transportation", "Solvd's custom software development services optimize and improve our " +
            "client's logistics and transportation businesses. We create cost-effective and time-saving " +
            "web and mobile applications that facilitate vehicle and freight tracking, incident management, " +
            "user-vehicle communication, route planning, enhanced security systems and more."),
    SOFTWARE_AND_HITECH("Software and Hi-Tech", "Solvd's engineers operate the latest technologies and upgrade different custom" +
            " projects. They continuously deliver updates, introduce new functionalities, " +
            "improve systems' scalability and user experience, automate legacy systems, " +
            "support complicated business logistics, and provide end-to-end testing.");

    private final String name;
    private final String description;

    Industry(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}