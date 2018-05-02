package springmanualgroup.fastwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springmanualgroup.fastwebapp.model.TestModel;

@Controller
@RequestMapping("/")
public class TestController {

    @GetMapping
    public ModelAndView get() {
        return new ModelAndView("testView", "testModel", new TestModel());
    }

    @PostMapping
    public ModelAndView post(@ModelAttribute("testModel") TestModel testModel) {
        if (null == testModel.getName() || testModel.getName().trim().length() == 0) {
            testModel.setName(null);
        }
        return new ModelAndView("testView", "testModel", testModel);
    }
}
