package digital.paisley.springmvcthymeleaf.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof DemoCustomHandlerExceptionResolver){
            modelAndView.setViewName("demoCustomHandlerResolverError");
        }
        modelAndView.addObject("exception",e.toString());
        return modelAndView;
    }
}
