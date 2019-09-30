package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String hello(){
      //  Calendar cal = Calendar.getInstance();
     //   Date date = cal.getTime();
     //   DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return "hello";
    }

}

