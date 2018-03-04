package at.wizi.blog.controller;

import at.wizi.blog.config.ApplicationConfig;
import at.wizi.blog.controller.model.WelcomeResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/welcome", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class WelcomeController {

    private final ApplicationConfig applicationConfig;

    public WelcomeController(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    @GetMapping
    public WelcomeResponse welcome() {
        return new WelcomeResponse(applicationConfig.getApplicationProperties().getWelcomeMessage());
    }
}
