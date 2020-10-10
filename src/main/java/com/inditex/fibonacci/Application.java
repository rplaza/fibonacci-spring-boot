package com.inditex.fibonacci;

import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import static java.lang.Boolean.FALSE;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Application {

    private static final String SPRING_DEV_TOOLS_RESTART_ENABLED = "spring.devtools.restart.enabled";

    static ConfigurableApplicationContext context;

    public static void main(final String[] args) {
        System.setProperty(SPRING_DEV_TOOLS_RESTART_ENABLED, FALSE.toString());
        val app = new SpringApplication(Application.class);
        context = app.run(args);
    }

}
