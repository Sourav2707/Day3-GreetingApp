package com.bridgelabz.mygreetingapp.controller;

import com.bridgelabz.mygreetingapp.entity.Greeting;
import com.bridgelabz.mygreetingapp.entity.User;
import com.bridgelabz.mygreetingapp.service.IgreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @Autowired
    IgreetingService greetingService;

    @GetMapping("")
    public String greeting(
            @RequestParam("firstName") Optional<String> firstName, @RequestParam("lastName") Optional<String> lastName) {
        User user = new User();
        user.setFirstName(firstName.isPresent() ? firstName.get(): null);
        user.setLastName(lastName.isPresent() ? lastName.get(): null);
        greetingService.addGreeting(user);
        return greetingService.getMessage();
    }

    @GetMapping("/id/{id}")
    public Greeting getByID(@PathVariable long id) {
        return greetingService.getGreetingById(id);
    }
    @GetMapping("/all")
    public List<Greeting> getAllGreeting(){
        return greetingService.getAllGreeting();
    }

    @PutMapping("/edit/{id}")
    public Greeting editGreeting(@PathVariable long id, @RequestParam("message") String message) {
        return greetingService.editGreeting(id, message);
    }
}
