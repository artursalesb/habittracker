package com.artur.habittracker.strategy;

import com.artur.habittracker.entity.Habit;
import com.artur.habittracker.enums.HabitType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HabitScoreCalculator {

    private final List<HabitScoreStrategy> strategies;

    public HabitScoreCalculator(List<HabitScoreStrategy> strategies) {
        this.strategies = strategies;
    }

    public int calculate(Habit habit) {

        HabitType type = habit.getType();

        HabitScoreStrategy strategy = strategies.stream()
                .filter(s -> s.getType().equals(type))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Strategy not found"));

        return strategy.calculateScore(habit);
    }
}