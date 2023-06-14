package com.bridgelabz.mygreetingapp.controller;

import com.bridgelabz.mygreetingapp.entity.Greeting;
import com.bridgelabz.mygreetingapp.entity.User;
import com.bridgelabz.mygreetingapp.service.IgreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    @Autowired
    IgreetingService greetingService;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam("firstName") Optional<String> firstName, @RequestParam("lastName") Optional<String> lastName) {
        User user = new User();
        user.setFirstName(firstName.isPresent() ? firstName.get(): null);
        user.setLastName(lastName.isPresent() ? lastName.get(): null);
        greetingService.addGreeting(user);
        return greetingService.getMessage();
    }

}
