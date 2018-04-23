package edu.hneu.kpp.lab2.spring.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ControllerConstants.BOOK_CONTROLLER_REQUEST_MAPPING)
public class BookController {
    private static final String VIEW_NAME = "bookList";

    @GetMapping
    public String get() {
        return VIEW_NAME;
    }
}
