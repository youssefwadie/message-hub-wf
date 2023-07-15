package com.github.youssefwadie.messagehub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;


@Configuration(proxyBeanMethods = false)
public class CassandraConfig {

    @Bean
    @Autowired
    public CqlSessionBuilderCustomizer cqlSessionBuilderCustomizer(final DataStaxAstraProperties astraProperties) {
        Path bundlePath = astraProperties.getSecureConnectBundle().toPath();
        return sessionBuilder -> sessionBuilder.withCloudSecureConnectBundle(bundlePath);
    }

}
