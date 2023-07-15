package com.github.youssefwadie.messagehub;

import com.github.youssefwadie.messagehub.config.DataStaxAstraProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = ReactiveUserDetailsServiceAutoConfiguration.class)
@EnableConfigurationProperties({
        DataStaxAstraProperties.class
})
public class MessageHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageHubApplication.class, args);
    }

}
