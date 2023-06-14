package com.bridgelabz.mygreetingapp.service;

import com.bridgelabz.mygreetingapp.entity.Greeting;
import com.bridgelabz.mygreetingapp.entity.User;

import java.util.List;

public interface IgreetingService {
    Greeting addGreeting(User user);

    String getMessage();
    Greeting getGreetingById(long id);
    List<Greeting> getAllGreeting();

    Greeting editGreeting(long id, String message);
}
