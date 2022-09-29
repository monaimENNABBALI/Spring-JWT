package jwtspringsec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jwtspringsec.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
