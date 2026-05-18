package com.artur.habittracker.service;

import com.artur.habittracker.entity.Habit;
import com.artur.habittracker.repository.HabitRepository;
import org.springframework.stereotype.Service;

@Service

public class HabitService {

    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public Habit createHabit(Habit habit) {
        return habitRepository.save(habit);
    }
}