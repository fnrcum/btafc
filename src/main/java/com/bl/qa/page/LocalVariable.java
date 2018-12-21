package com.bl.qa.page;

import cucumber.runtime.java.guice.ScenarioScoped;

import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class LocalVariable {

    private static Map<String, String> scenarioVariables = new HashMap<>();

    public static void put(String key, String value) {
        scenarioVariables.put(key, value);
    }

    public static String get(String value) {
        return scenarioVariables.get(value);
    }
}
