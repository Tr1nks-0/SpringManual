package edu.hneu.kpp.lab2.spring.webapp.controller;

import edu.hneu.kpp.lab2.spring.service.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping(ControllerConstants.AUTHOR_CONTROLLER_REQUEST_MAPPING)
public class AuthorController {
    private static final String VIEW_LIST_NAME = "authorList";
    private static final String MODEL_LIST_NAME = "authorListModel";
    private static final String VIEW_SINGLE_NAME = "author";
    private static final String MODEL_SINGLE_NAME = "authorModel";
    @Resource
    private AuthorService authorService;

    @GetMapping
    public ModelAndView get(@RequestParam(required = false) Integer id) {
        if (null == id) {
            return new ModelAndView(VIEW_LIST_NAME, MODEL_LIST_NAME, authorService.findAll());
        } else {
            return new ModelAndView(VIEW_SINGLE_NAME, MODEL_SINGLE_NAME, authorService.findById(id));
        }
    }

    @GetMapping("rest")
    @ResponseBody
    public Object getRest(@RequestParam(required = false) Integer id) {
        if (null == id) {
            return authorService.findAll();
        } else {
            return authorService.findById(id);
        }
    }
}
