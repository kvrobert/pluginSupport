package com.robesz.plugin1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@Slf4j
@SpringBootApplication
public class Plugin1Application {

    public static void main(String[] args) {
       SpringApplication.run(Plugin1Application.class, args);

        System.out.println("Enter  the name of plugin to execute");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        Class cls;
        Plugin plugin;
        try {
            cls = Class.forName("com.robesz.plugin1" + name);
            Object obj = cls.newInstance();

            if(obj instanceof Plugin){
                plugin = (Plugin) obj;
                plugin.run();
            }

        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            log.error(e.getMessage());
        }


    }





}
