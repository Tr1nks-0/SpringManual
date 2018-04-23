package edu.hneu.kpp.lab2.spring.service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "edu.hneu.kpp.lab2.spring")
@EnableAutoConfiguration
@ComponentScan({
        "edu.hneu.kpp.lab2.spring.service",
        "edu.hneu.kpp.lab2.spring.dao",
})
public class Application extends SpringBootServletInitializer {
    public static final Class[] classes = {Application.class,};
    public static ApplicationContext ac;


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(classes);
    }

    public static void main(String[] args) {
        System.setProperty("spring.config.location", "classpath:/application-service.properties," +
                "classpath:/application-repository.properties");
        ac = SpringApplication.run(classes, args);
    }
}
