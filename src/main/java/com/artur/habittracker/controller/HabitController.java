package com.artur.habittracker.controller;

import com.artur.habittracker.entity.Habit;
import com.artur.habittracker.service.HabitService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @PostMapping
    public Habit createHabit(@RequestBody Habit habit) {
        return habitService.createHabit(habit);
    }
}