package com.example.scheduler.observer;

import com.example.scheduler.model.Task;
import org.springframework.stereotype.Component;

@Component
public class LoggingObserver implements TaskObserver {

    @Override
    public void onTaskExecuted(Task task) {
        System.out.println("[Log] Tarefa executada: " + task.getId());
    }
}
