package com.zhss.boot;

import com.zhss.boot.config.DruidDataSourceConfig;
import com.zhss.boot.listener.MyApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(DruidDataSourceConfig.class)
@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BootApplication.class);
        application.addListeners(new MyApplicationStartedEventListener());
        application.run(args);
//        SpringApplication.run(BootApplication.class,args);
    }
}
