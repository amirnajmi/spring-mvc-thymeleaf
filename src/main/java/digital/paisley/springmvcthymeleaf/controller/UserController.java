package digital.paisley.springmvcthymeleaf.controller;

import digital.paisley.springmvcthymeleaf.exception.DemoException;
import digital.paisley.springmvcthymeleaf.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> list = new ArrayList<>();
        User amirHossein_najmi = new User(1, "AmirHossein Najmi", "123", "am.nj@outlook.com");
        list.add(amirHossein_najmi);
        logger.debug("this is the debug level log");
        model.addAttribute("list", list);
        return "studentlist";
    }

    @RequestMapping("/add")
    public String toAdd(User user) {
        return "userCreation";
    }

    @RequestMapping("/addUser")
    public String add(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "userCreation";
        } else return "success";
    }

    @RequestMapping("/globalException")
    public String throwAnGlobalException(){
        int error = 10 / 0 ;
        return "success";
    }
    @RequestMapping("/localException")
    public String throwAnLocalException(){
        throw new DemoException();
    }

    @ExceptionHandler(value = {DemoException.class})
    public ModelAndView handleDemoException(Exception ex){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex.toString());
        modelAndView.setViewName("demoError");
        return modelAndView;
    }

}
