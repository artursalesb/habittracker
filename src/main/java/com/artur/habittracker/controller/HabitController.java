package com.artur.habittracker.controller;
import java.util.List;
import com.artur.habittracker.entity.Habit;
import com.artur.habittracker.service.HabitService;
import com.artur.habittracker.dto.CreateHabitRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @PostMapping
    public Habit createHabit(@Valid @RequestBody CreateHabitRequest request) {
        return habitService.createHabit(request);
    }
    @GetMapping
    public List<Habit> getAllHabits() {
        return habitService.getAllHabits();
    }
}