package com.bridgelabz.mygreetingapp.service;

import com.bridgelabz.mygreetingapp.entity.Greeting;
import com.bridgelabz.mygreetingapp.entity.User;
import com.bridgelabz.mygreetingapp.reposirtoy.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IgreetingService {
    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hello %s";
    String message;
    @Autowired
    private GreetingRepository greetingRepository;
    @Override
    public Greeting addGreeting(User user) {
        message = String.format(template, user.getName());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public String getMessage() {
        return message;
    }
}
