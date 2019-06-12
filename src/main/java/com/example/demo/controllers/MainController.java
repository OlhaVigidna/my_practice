package com.example.demo.controllers;

import com.example.demo.models.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by okten225 on 6/12/19.
 */

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model){
        return "home";
    }

    @PostMapping("/saveDocument")
    public String save(@RequestPart(name = "file", required = false) MultipartFile file) {
        try {
            System.out.println(file.getBytes().length);
        } catch (IOException e) {
            System.out.println("!!!!!");
        }
        return "second";
    }
}
