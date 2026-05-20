package com.artur.habittracker.service;
import java.util.List;
import com.artur.habittracker.entity.Habit;
import com.artur.habittracker.repository.HabitRepository;
import com.artur.habittracker.exception.ResourceNotFoundException;
import com.artur.habittracker.dto.CreateHabitRequest;
import com.artur.habittracker.dto.UpdateHabitRequest;
import com.artur.habittracker.strategy.HabitScoreCalculator;
import org.springframework.stereotype.Service;

@Service

public class HabitService {

    private final HabitRepository habitRepository;
    private final HabitScoreCalculator scoreCalculator;

    public HabitService(HabitRepository habitRepository, HabitScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
        this.habitRepository = habitRepository;
    }

    public Habit createHabit(CreateHabitRequest request) {

        Habit habit = new Habit();

        habit.setName(request.getName());
        habit.setDescription(request.getDescription());
        habit.setStreak(request.getStreak());
        habit.setType(request.getType());

        return habitRepository.save(habit);
    }
    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }
    public Habit getHabitById(Long id) {
        return habitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found"));
    }
    public void deleteHabit(Long id) {

        Habit habit = getHabitById(id);

        habitRepository.delete(habit);
    }
    public Habit updateHabit(Long id, UpdateHabitRequest request) {

        Habit habit = getHabitById(id);

        habit.setName(request.getName());
        habit.setDescription(request.getDescription());
        habit.setStreak(request.getStreak());
        habit.setType(request.getType());

        return habitRepository.save(habit);
    }
    public int calculateHabitScore(Long id) {

        Habit habit = getHabitById(id);

        return scoreCalculator.calculate(habit);
    }
}