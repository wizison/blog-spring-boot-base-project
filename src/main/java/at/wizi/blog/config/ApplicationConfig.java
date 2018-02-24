package at.wizi.blog.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "base")
public class ApplicationConfig {
    private Long maxEntries;
    /**
     * the message for the welcome controller
     */
    private String welcomeMessage;
}
