package com.tangdesam.todoapp.dao;

import com.tangdesam.todoapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Task, String> {
}
