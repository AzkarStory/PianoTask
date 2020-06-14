package dev.azkar.roomprogram.piano.task.repository;

import dev.azkar.roomprogram.piano.task.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Person,Long> {
}
