package com.bridgelabz.mygreetingapp.service;

import com.bridgelabz.mygreetingapp.entity.Greeting;
import com.bridgelabz.mygreetingapp.entity.User;

public interface IgreetingService {
    Greeting addGreeting(User user);

    String getMessage();
}
