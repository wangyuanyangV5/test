package com.zhss.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
public class EnvironmentConfig {
    @Autowired
    private Environment environment;

    public int getServerPort(){
        return environment.getProperty("server.port",Integer.class);
    }
}
