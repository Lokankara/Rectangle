package main.java.com.ua.univer.config;

import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(jakarta.servlet.ServletContext servletContext) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(WebMvcConfig.class);

        ServletRegistration.Dynamic dispatch = servletContext.addServlet(
                "Spring Dispatcher", new DispatcherServlet((WebApplicationContext) servletContext));
        dispatch.setLoadOnStartup(1);
        dispatch.addMapping("/");
    }
}
