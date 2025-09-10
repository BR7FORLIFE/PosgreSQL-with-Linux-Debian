package com.archives.OAuth2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Example {

    @GetMapping("/public")
    public String rutePublic() {
        return "Rute public";
    }

    @GetMapping("/secured")
    public String ruteSecured() {
        return "Rute secured";
    }

    @GetMapping("/secured/2")
    public String ruteSecured2() {
        return "rute secured 2";
    }
}
