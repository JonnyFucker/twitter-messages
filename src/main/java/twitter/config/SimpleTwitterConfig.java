package twitter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

/**
 * Created by Tomek on 2016-10-16.
 */
@Configuration
public class SimpleTwitterConfig {

    private static Twitter twitter;

    public SimpleTwitterConfig() {

        if (twitter == null) {
            twitter = new TwitterTemplate("oznLh8eKfSOWWBgdCGmh2M9zY","CO92ffOzFI9jx91r7dbMbEPQLWZjjt6B8eT8IEH9WPoDBa4R4a","787699883201396736-AiRwCm3REDZTtihEeqHqhjidaBJIxre","h588v4ZtNl8ruALtq9ZUste7UObPEjO2caO4r5CWgQ4fW");
        }
    }

    /**
     * A proxy to a request-scoped object representing the simplest Twitter API
     * - one that doesn't need any authorization
     */
    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Twitter twitter() {
        return twitter;
    }

}