package com.chaski.classdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class FrontEnd  {
    @GetMapping("/")
    public String home(Model model) {
        return "Home";
    }
}