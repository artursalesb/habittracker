package com.artur.habittracker.service;
import java.util.List;
import com.artur.habittracker.entity.Habit;
import com.artur.habittracker.repository.HabitRepository;
import com.artur.habittracker.dto.CreateHabitRequest;
import org.springframework.stereotype.Service;

@Service

public class HabitService {

    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public Habit createHabit(CreateHabitRequest request) {

        Habit habit = new Habit();

        habit.setName(request.getName());
        habit.setDescription(request.getDescription());
        habit.setStreak(request.getStreak());

        return habitRepository.save(habit);
    }
    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }
    public Habit getHabitById(Long id) {
        return habitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habit not found"));
    }
}