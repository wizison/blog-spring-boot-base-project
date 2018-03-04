package at.wizi.blog.controller;

import at.wizi.blog.config.ApplicationConfig;
import at.wizi.blog.config.properties.ApplicationProperties;
import at.wizi.blog.controller.model.WelcomeResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ContextConfiguration(classes = WelcomeControllerTest.TestConfig.class)
public class WelcomeControllerTest {

    @Configuration
    static class TestConfig {

        @Bean
        public ApplicationProperties applicationProperties() {
            ApplicationProperties applicationProperties = new ApplicationProperties();
            applicationProperties.setWelcomeMessage("test welcome message");
            return applicationProperties;
        }

        @Bean
        public ApplicationConfig applicationConfig(final ApplicationProperties applicationProperties) {
            return new ApplicationConfig(applicationProperties);
        }
    }

    @Autowired
    private ApplicationConfig applicationConfig;

    private WelcomeController welcomeController;

    @Before
    public void setUp() {
        welcomeController = new WelcomeController(applicationConfig);
    }

    @Test
    public void welcome() {
        final WelcomeResponse welcomeResponse = welcomeController.welcome();
        assertThat(welcomeResponse).isNotNull();
        assertThat(welcomeResponse.getWelcomeMessage()).isNotBlank();
        assertThat(welcomeResponse.getWelcomeMessage()).containsIgnoringCase("test");
    }
}
