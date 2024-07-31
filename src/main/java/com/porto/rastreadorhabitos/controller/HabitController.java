package com.porto.rastreadorhabitos.controller;

import com.porto.rastreadorhabitos.models.Habit;
import com.porto.rastreadorhabitos.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitController {
    @Autowired
    private HabitService habitService;

    @GetMapping
    public List<Habit> getAllHabits() {
        return habitService.findAllHabits();
    }

    @GetMapping("/{id}")
    public Habit getHabitById(@PathVariable Long id) {
        return habitService.getHabitById(id)
                .orElseThrow(() -> new RuntimeException("Hábito não encontrado na base de dados"));
    }

    @PostMapping
    public Habit createHabit(@RequestBody Habit habit) {
        return habitService.createHabit(habit);
    }

    @PutMapping("/{id}")
    public Habit updateHabit(@PathVariable Long id, Habit habitDetails) {
        return habitService.updateHabit(id, habitDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteHabit(@PathVariable Long id) {
        habitService.deleteHabit(id);
    }
}
