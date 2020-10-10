package digital.paisley.springmvcthymeleaf.config;

import digital.paisley.springmvcthymeleaf.exception.DemoCustomHandlerExceptionResolver;
import digital.paisley.springmvcthymeleaf.exception.DemoSimpleMappingException;
import digital.paisley.springmvcthymeleaf.exception.MyHandlerExceptionResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class ExceptionConfig {

    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties mapping = new Properties();
        mapping.put("digital.paisley.springmvcthymeleaf.exception.DemoSimpleMappingException", "demoSimpleMappingError");
        resolver.setExceptionMappings(mapping);
        return resolver;
    }

    @Bean
    HandlerExceptionResolver customExceptionResolver () {
        return new MyHandlerExceptionResolver();
    }

}
