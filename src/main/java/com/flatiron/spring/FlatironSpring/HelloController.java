package com.flatiron.spring.FlatironSpring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j

@RestController
public class HelloController {

    private JokeService jokeService;

    public HelloController(JokeService jokeService) {
        this.jokeService = jokeService;
    }
    @GetMapping("/api/status")
    public String status() {
        return "Congratulations - you must be an admin since you can see the application's status information";
    }

//    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/api/hello")
    public String hello(@RequestParam(name = "targetName", defaultValue = "Stephanie") String name) {
        System.out.println("In HelloController.hello() method");
//        logger.info("In HelloController.hello() method");
        log.info("In HelloController.hello() method");
        String greeting = "Hello " + name;
        greeting += "<br/>";
        greeting += "Dad joke of the moment: " + jokeService.getDadJoke();
        return greeting;
    }


//    @GetMapping("/reverse")
//    public String reverse(String stringToReverse) {
//        return String.format(String.valueOf(new StringBuilder().append(stringToReverse).reverse()));
//    }
}
