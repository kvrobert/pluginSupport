package com.robesz;

import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws MalformedURLException {

       /* File loc = new File("plugins");
        System.out.println("directory: " + loc.getName());
        System.out.println("directory: " + loc.getPath());
        File[] flist = loc.listFiles(new FileFilter() {
            public boolean accept(File file) {return file.getPath().toLowerCase().endsWith(".jar");}
        });
        System.out.println("Files: " + flist.length);
        System.out.println("Files: " + flist[0].getName());
        URL[] urls = new URL[flist.length];

        for (int i = 0; i < flist.length; i++)
            urls[i] = flist[i].toURI().toURL();
        URLClassLoader ucl = new URLClassLoader(urls);

        ServiceLoader<PluginService> sl = ServiceLoader.load(PluginService.class, ucl);

        sl.forEach(f -> f.run());

        System.out.println("And again all of them....\n\n");

        List<PluginService> pluginServices = new ArrayList<>();
        sl.forEach( plugin -> pluginServices.add(plugin));

        for (PluginService plugin : pluginServices){
            plugin.run();
            plugin.showCollectionInterval();
        }
*/

      PluginLoader.getInstance("plugins").getPlugins().forEach(f-> {
          f.run();
          f.showCollectionInterval();
      });

    }


}
