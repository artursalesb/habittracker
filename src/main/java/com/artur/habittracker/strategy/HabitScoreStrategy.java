package com.artur.habittracker.strategy;

import com.artur.habittracker.entity.Habit;
import com.artur.habittracker.enums.HabitType;

public interface HabitScoreStrategy {

    HabitType getType();

    int calculateScore(Habit habit);
}