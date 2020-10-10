package digital.paisley.springmvcthymeleaf.controller;

import digital.paisley.springmvcthymeleaf.exception.DemoCustomHandlerExceptionResolver;
import digital.paisley.springmvcthymeleaf.exception.DemoException;
import digital.paisley.springmvcthymeleaf.exception.DemoSimpleMappingException;
import digital.paisley.springmvcthymeleaf.exception.GeneralException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

    @RequestMapping("/generalException")
    public String throwGeneralException(){
        throw new GeneralException();
    }

    @RequestMapping("/localException")
    public String throwAnLocalException(){
        throw new DemoException();
    }

    @RequestMapping("/globalException")
    public String throwAnGlobalException(){
        int error = 10 / 0 ;
        return "success";
    }

    @RequestMapping("/simpleMappingExceptionResolver")
    public String throwExceptionHandledBySimpleMappingResolver(){
        throw new DemoSimpleMappingException();
    }
    @RequestMapping("/customHandlerExceptionResolver")
    public String throwExceptionHandledByCustomHandlerExceptionResolver(){
        throw new DemoCustomHandlerExceptionResolver();
    }

    @ExceptionHandler(value = {DemoException.class})
    public ModelAndView handleDemoException(Exception ex){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex.toString());
        modelAndView.setViewName("demoError");
        return modelAndView;
    }
}
