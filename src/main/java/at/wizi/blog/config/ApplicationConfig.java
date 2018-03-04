package at.wizi.blog.config;

import at.wizi.blog.config.properties.ApplicationProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@EnableConfigurationProperties(ApplicationProperties.class)
public class ApplicationConfig {
    private final ApplicationProperties applicationProperties;

    @Autowired
    public ApplicationConfig(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }
}
