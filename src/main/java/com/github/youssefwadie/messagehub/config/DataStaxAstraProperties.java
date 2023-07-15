package com.github.youssefwadie.messagehub.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.File;

@Getter
@Setter
@ConfigurationProperties(prefix = "datastax.astra")
public class DataStaxAstraProperties {
    private File secureConnectBundle;
}
