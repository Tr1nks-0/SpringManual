package edu.hneu.kpp.lab2.spring.webapp.controller;

import edu.hneu.kpp.lab2.spring.service.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(ControllerConstants.BOOK_CONTROLLER_REQUEST_MAPPING)
public class BookController {
    private static final String VIEW_LIST_NAME = "bookList";
    private static final String MODEL_LIST_NAME = "bookListModel";
    private static final String VIEW_SINGLE_NAME = "book";
    private static final String MODEL_SINGLE_NAME = "bookModel";
    @Resource
    private BookService bookService;

    @GetMapping
    public ModelAndView get(@RequestParam(required = false) Integer id) {
        if (null == id) {
            return new ModelAndView(VIEW_LIST_NAME, MODEL_LIST_NAME, bookService.findAll());
        } else {
            return new ModelAndView(VIEW_SINGLE_NAME, MODEL_SINGLE_NAME, bookService.findById(id));
        }
    }
}


