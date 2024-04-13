package com.tangdesam.todoapp;

import com.tangdesam.todoapp.dao.TaskDao;
import com.tangdesam.todoapp.entity.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TodoAppApplicationTests {

	@Autowired
	private TaskDao taskDao;

	@Test
	void contextLoads() {
		// test read from database to verify there's no syntax error
		List<Task> taskList = taskDao.findAll();
		for (Task task : taskList) {
			System.out.println(task.isDone() + " | " + task.getText());
		}
	}

}
