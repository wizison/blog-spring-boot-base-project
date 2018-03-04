package at.wizi.blog.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "base")
public class ApplicationProperties {
    private Long maxEntries;
    /**
     * the message for the welcome controller
     */
    private String welcomeMessage;
}
