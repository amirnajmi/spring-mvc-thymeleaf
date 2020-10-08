package digital.paisley.springmvcthymeleaf.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView handleArithmeticException(ArithmeticException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(ex.getMessage());
        modelAndView.setViewName("globalError");
        return modelAndView;
    }

}
