package com.zhss.boot.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;


@SuppressWarnings("deprecation")
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("系统启动成功");
    }
}
