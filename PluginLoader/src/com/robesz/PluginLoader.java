package com.robesz;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class PluginLoader {

    private static PluginLoader pluginLoader;
    private ServiceLoader<PluginService> serviceLoader;

    private PluginLoader(ServiceLoader<PluginService> serviceLoader) {
        this.serviceLoader = serviceLoader;
    }

    public static synchronized PluginLoader getInstance(String pluginFolder) throws MalformedURLException {

        if (pluginLoader != null) {
            return pluginLoader;
        } else {

            File loc = new File(pluginFolder);
            if(!loc.exists()){
                throw new RuntimeException("Plugin folder not exist");
            }
            System.out.println("directory: " + loc.getPath());
            System.out.println("full directory: " + loc.getAbsolutePath());

            File[] files = loc.listFiles(file -> file.getPath().toLowerCase().endsWith(".jar"));

            System.out.println("Files: " + files.length);
            URL[] urls = new URL[files.length];

            for (int i = 0; i < files.length; i++) {
                urls[i] = files[i].toURI().toURL();
            }
            URLClassLoader ucl = new URLClassLoader(urls);

            ServiceLoader<PluginService> sl = ServiceLoader.load(PluginService.class, ucl);
            pluginLoader = new PluginLoader(sl);
            return pluginLoader;
        }
    }

    public List<PluginService> getPlugins() {
        List<PluginService> plugins = new ArrayList<>();
        this.serviceLoader.forEach(plugin -> plugins.add(plugin));
        return plugins;
    }
}
