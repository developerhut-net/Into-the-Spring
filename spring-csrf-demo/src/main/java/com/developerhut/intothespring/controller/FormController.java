package com.developerhut.intothespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FormController {

	@GetMapping("/form")
    public String showForm() {
        return "csrf-form";
    }

    @PostMapping("/submit")
    public String processForm(Model model, HttpServletRequest request) {
    	model.addAttribute("data", request.getParameter("data"));
        return "success";
    }
    
}
