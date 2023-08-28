package com.qaprosoft.carina.demo.gui.components.solvd.enums;

import java.util.Arrays;
import java.util.List;

public enum MVPBlocks {
    FIRST("Go from idea to product in a short time", Arrays.asList("The Minimum Viable Product is a version of the product that has a sufficient set of features\n" +
            "and is usually developed in a short period of time. Once you have a clear idea and you have conducted the initial research, the next step is to test your hypothesis in real life.", "With a small investment of time and capital, you will be able to see if your idea is needed on the market\n" +
            "and understand how your customers react to it.", "In just 2 months, we can deliver a working web or mobile application, which you can then use\n" +
            "to receive valuable feedback from your first customers for future development.")),
    SECOND("A team of experts", Arrays.asList("If you are struggling to find a perfect team to develop your idea into a product, hiring an offshore company\n" +
            "like Solvd can be a great solution.", "Solvd can become a major competitive advantage for you since we will greatly help reduce costs and time spent\n" +
            "on hiring local full-time employees. You can then focus on your idea while we focus on its development.", "The team can be customized according to your needs. We give you access to talented resources of different skills\n" +
            "and expertise: Business Analysts, UX/UI Designers, Front-end and Back-end Engineers, Android and iOS developers, Quality Assurance Engineers and Project Managers.")),
    THIRD("We are obsessed with quality", Arrays.asList("We always follow best practices of the agile development process, working in sprints that last from one to two weeks.\n" +
            "During these sprints, we always stay in contact with our clients to ensure transparency and professional cooperation.", "In our working process we incorporate planning, executing, and evaluating phases. At the end of each sprint we\n" +
            "perform a demo that provides visible and continuous progress.", "We are passionate about Quality Assurance. We apply our knowledge in Manual Testing gained from years of experience\n" +
            "in various projects to make sure the experience of your customers isn’t spoiled by any pesky bugs.")),
    FOURTH("A long-term partnership", Arrays.asList("We care about your idea, and before committing to any development we study the hypothesis, potential market,\n" +
            "and competitors in order to develop profitable software that your customers will favor in the future.", "We build high-quality Minimum Viable Products that scale and can later become fully-featured web\n" +
            "or mobile applications.", "We care about your success so we will be there for as long as you need us. We are able to support\n" +
            "you until your startup skyrockets, and will even be there for maintenance after."));

    private final String name;
    private final List<String> descriptions;

    MVPBlocks(String name, List<String> descriptions) {
        this.name = name;
        this.descriptions = descriptions;
    }

    public String getName() {
        return name;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }
}
