package edu.hneu.kpp.lab2.spring.webapp.controller;

import edu.hneu.kpp.lab2.spring.service.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(ControllerConstants.BOOK_REST_CONTROLLER_REQUEST_MAPPING)
public class BookRestController {
    @Resource
    private BookService bookService;

    @GetMapping
    public Object getById(@RequestParam(required = false) Integer id) {
        if (null == id) {
            return bookService.findAll();
        } else {
            return bookService.findById(id);
        }
    }
}
