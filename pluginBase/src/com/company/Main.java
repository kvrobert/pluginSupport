package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter  the name of plugin to execute");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        Class[] classes;

        Class cls;
        Plugin plugin;
        try {
            cls = Class.forName("com.company." + name);
            Object obj = cls.newInstance();

            if(obj instanceof Plugin){
                plugin = (Plugin) obj;
                plugin.run();
            }

        } catch (ClassNotFoundException e) {
            System.err.println(e.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err.println(e.toString());
        }


        File[] files = new File("./src/com/company").listFiles();
        for (File file : files){
           // System.out.println(file.getName());
            try {

                cls = Class.forName("com.company." + file.getName().split("\\.")[0]);
                Object obj = cls.isInterface() ? null : cls.newInstance();

                if(obj instanceof Plugin){
                    plugin = (Plugin) obj;
                    plugin.run();
                }
            } catch (ClassNotFoundException e) {
                System.err.println(e.toString());
            } catch (IllegalAccessException e) {
                System.err.println(e.toString());
            } catch (InstantiationException e) {
                System.err.println(e.toString());
            }
        }

    }

}
