package com.artur.habittracker.strategy;

import com.artur.habittracker.entity.Habit;
import com.artur.habittracker.enums.HabitType;
import org.springframework.stereotype.Component;

@Component
public class DailyHabitStrategy implements HabitScoreStrategy {

    @Override
    public HabitType getType() {
        return HabitType.DAILY;
    }

    @Override
    public int calculateScore(Habit habit) {
        return habit.getStreak();
    }
}