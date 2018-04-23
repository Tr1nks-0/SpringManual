package edu.hneu.kpp.lab2.spring.webapp.controller;

import edu.hneu.kpp.lab2.spring.service.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(ControllerConstants.BOOK_CONTROLLER_REQUEST_MAPPING)
public class BookController {
    private static final String VIEW_NAME = "bookList";
    private static final String MODEL_NAME = "bookListModel";
    @Resource
    private BookService bookService;

    @GetMapping
    public ModelAndView get() {
        return new ModelAndView(VIEW_NAME, MODEL_NAME, bookService.findAll());
    }
}

