package com.artur.habittracker.service;

import org.springframework.stereotype.Service;

@Service
public class HomeService {

    public String getWelcomeMessage() {
        return "Habit Tracker API is running!";
    }
}