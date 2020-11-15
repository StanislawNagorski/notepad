package com.sda.training.spring.notepad.services.loggers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
@Slf4j
public class DevLogger implements CustomLogger {
    @Override
    public void log(String message, String param) {
        log.info("{}, {}" ,message,param);
    }
}
