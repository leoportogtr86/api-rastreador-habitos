package com.porto.rastreadorhabitos.repository;

import com.porto.rastreadorhabitos.models.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit, Long> {
}
