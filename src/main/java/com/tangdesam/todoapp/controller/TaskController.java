package com.tangdesam.todoapp.controller;

import com.tangdesam.todoapp.dao.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskDao taskDao;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("taskList", taskDao.findAll());
        return("task/list");
    }

}
