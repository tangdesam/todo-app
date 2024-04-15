package com.tangdesam.todoapp.controller;

import com.tangdesam.todoapp.dao.TaskDao;
import com.tangdesam.todoapp.entity.Task;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("task", new Task());
        return("task/create");
    }

    @PostMapping("/save")
    public String save(RedirectAttributes redirectAttributes, @Valid Task task, BindingResult result) {

        if (result.hasErrors()) {
            return "task/create";
        }

        taskDao.save(task);

        redirectAttributes.addFlashAttribute("message", "Task created");
        redirectAttributes.addFlashAttribute("messageCss", "alert alert-success");

        return("redirect:/task/list");
    }

}
