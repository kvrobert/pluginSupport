package com.robesz;

import java.util.Objects;

public class DockerDataCollector implements PluginService {
    public DockerDataCollector() {
    }

    public void run() {
        System.out.println("DockerDataCollector running.....");
    }

    @Override
    public void showCollectionInterval() {
        String runtime = Objects.nonNull(System.getenv("dataCollector_docker")) ? System.getenv("dataCollector_docker") : String.valueOf(DEFAULT_RUNTIME);
        System.out.println("DockerDataCollector collecting time: " + runtime);
    }
}

