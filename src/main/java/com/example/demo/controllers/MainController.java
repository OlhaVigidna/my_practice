package com.example.demo.controllers;

import com.example.demo.models.DocumentDetails;
import com.example.demo.models.Tag;
import com.example.demo.service.DocumentDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.beans.PropertyEditor;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

/**
 * Created by okten225 on 6/12/19.
 */

@Controller
@AllArgsConstructor
public class MainController {

    private DateCustomerEditor dateCustomerEditor;
    private DocumentDetailsService documentDetailsService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tags", Tag.values());
        model.addAttribute("details", new DocumentDetails());
        return "home";
    }

    @PostMapping("/saveDocument")
    public String save(@RequestPart(name = "file", required = false) MultipartFile file,
//                       @RequestParam("date")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
                       DocumentDetails details) throws IOException {

//        System.out.println(file.getOriginalFilename());
//
//
//
//        String pathCurrent = System.getProperty("user.home") + File.separator + "savedFromMyPracticeDocuments" + File.separator;

//        details.setSize(file.getBytes().length);
//        details.setType(file.getContentType());
//        details.setDocumentName(file.getOriginalFilename());
//        details.setPath(pathCurrent);

//        System.out.println(pathCurrent);
//        file.transferTo(Paths.get(pathCurrent + file.getOriginalFilename()));
//
//
//        System.out.println(details);
//        System.out.println(new DocumentDetails());

        documentDetailsService.saveDetails(file, details);

        List<DocumentDetails> all = documentDetailsService.findAll();
        for (DocumentDetails documentDetails : all) {
            System.out.println(documentDetails);
        }


        return "second";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, dateCustomerEditor);
        System.out.println("!!!!!");
    }
}
