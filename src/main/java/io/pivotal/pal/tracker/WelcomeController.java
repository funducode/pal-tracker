package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class WelcomeController {
    public String message;

    public WelcomeController(@Value("${welcome.message}") String message){
        this.message = message;
    }

    @GetMapping("/")
    public String hello(){
        return message;
    }




}

