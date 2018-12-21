package com.bl.qa.config;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class ServerUrl {

    @Inject
    @Named("fcs.default.url")
    private String fcsDefaultUrl;

    public String getFcsDefaultUrl() {
        return fcsDefaultUrl;
    }
}