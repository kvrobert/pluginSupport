package com.robesz;

import java.util.Objects;

public class SystemDataCollector implements PluginService {



    @Override
    public void run() {
        System.out.println("SystemDataCollector is running......");
    }

    @Override
    public void showCollectionInterval() {
        String runtime = Objects.nonNull(System.getenv("dataCollector_system")) ? System.getenv("dataCollector_system") : String.valueOf(DEFAULT_RUNTIME);
        System.out.println("SystemDataCollector collecting time: " + runtime);
    }
}
