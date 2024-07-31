package com.porto.rastreadorhabitos.service;

import com.porto.rastreadorhabitos.models.Habit;
import com.porto.rastreadorhabitos.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitService {
    @Autowired
    private HabitRepository habitRepository;

    public List<Habit> findAllHabits() {
        return habitRepository.findAll();
    }

    public Optional<Habit> getHabitById(Long id) {
        return habitRepository.findById(id);
    }

    public Habit createHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    public Habit updateHabit(Long id, Habit habitDetails) {
        Habit habit = habitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hábito não encontrado"));

        habitDetails.setCompleted(habit.isCompleted());
        habitDetails.setName(habit.getName());
        habitDetails.setStartDate(habit.getStartDate());

        return habitRepository.save(habit);
    }

    public void deleteHabit(Long id) {
        Habit habit = habitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hábito não encontrado"));

        habitRepository.delete(habit);
    }
}
