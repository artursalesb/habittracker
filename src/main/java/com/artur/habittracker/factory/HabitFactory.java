package com.artur.habittracker.factory;

import com.artur.habittracker.dto.CreateHabitRequest;
import com.artur.habittracker.entity.Habit;
import org.springframework.stereotype.Component;

@Component
public class HabitFactory {

    public Habit createHabit(CreateHabitRequest request) {

        Habit habit = new Habit();

        habit.setName(request.getName());
        habit.setDescription(request.getDescription());
        habit.setStreak(request.getStreak());
        habit.setType(request.getType());

        return habit;
    }
}