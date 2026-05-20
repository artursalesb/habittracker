package com.artur.habittracker.strategy;

import com.artur.habittracker.entity.Habit;
import com.artur.habittracker.enums.HabitType;
import org.springframework.stereotype.Component;

@Component
public class MonthlyHabitStrategy implements HabitScoreStrategy {

    @Override
    public HabitType getType() {
        return HabitType.MONTHLY;
    }

    @Override
    public int calculateScore(Habit habit) {
        return habit.getStreak() * 10;
    }
}