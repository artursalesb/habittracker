package com.artur.habittracker.controller;
import java.util.List;
import com.artur.habittracker.entity.Habit;
import com.artur.habittracker.service.HabitService;
import com.artur.habittracker.dto.CreateHabitRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import com.artur.habittracker.dto.UpdateHabitRequest;
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
    @GetMapping("/{id}")
    public Habit getHabitById(@PathVariable Long id) {
        return habitService.getHabitById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabit(@PathVariable Long id) {

        habitService.deleteHabit(id);

        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public Habit updateHabit(
            @PathVariable Long id,
            @Valid @RequestBody UpdateHabitRequest request) {

        return habitService.updateHabit(id, request);
    }
}