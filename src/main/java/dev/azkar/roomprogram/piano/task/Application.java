package dev.azkar.roomprogram.piano.task;

import dev.azkar.roomprogram.piano.task.controller.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    @Autowired
    MainController mainController;

    public static void main(String[]args){
        SpringApplication.run(Application.class, args);
    }

}

