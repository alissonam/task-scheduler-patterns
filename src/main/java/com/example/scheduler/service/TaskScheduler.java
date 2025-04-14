package com.example.scheduler.service;

import com.example.scheduler.model.Task;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class TaskScheduler {

    private final Queue<Task> taskQueue = new LinkedList<>();

    public void schedule(Task task) {
        taskQueue.offer(task);
        System.out.println("Tarefa agendada: " + task.getId());
    }

    public void runNext() {
        Task task = taskQueue.poll();
        if (task != null) {
            System.out.println("Executando tarefa: " + task.getId());
            task.getCommand().execute();
        } else {
            System.out.println("Nenhuma tarefa na fila.");
        }
    }
}
