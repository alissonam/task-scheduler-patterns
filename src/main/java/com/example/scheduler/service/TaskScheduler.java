package com.example.scheduler.service;

import com.example.scheduler.memento.TaskHistory;
import com.example.scheduler.memento.TaskMemento;
import com.example.scheduler.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
@RequiredArgsConstructor
public class TaskScheduler {

    private final TaskHistory taskHistory;
    private final Queue<Task> taskQueue = new LinkedList<>();

    public void schedule(Task task) {
        taskQueue.offer(task);
        System.out.println("Tarefa agendada: " + task.getId());
    }

    public void runNext() {
        Task task = taskQueue.poll();
        if (task != null) {
            // Salvar estado antes da execução
            taskHistory.save(new TaskMemento(task.getId(), task.getCommand()));
            System.out.println("Executando tarefa: " + task.getId());
            task.getCommand().execute();
        } else {
            System.out.println("Nenhuma tarefa na fila.");
        }
    }

    public void undoLast() {
        if (taskHistory.hasUndo()) {
            TaskMemento memento = taskHistory.undo();
            System.out.println("Desfazendo tarefa: " + memento.getId());
            // Simula uma restauração — poderia reexecutar de forma reversa ou re-agendar
            schedule(new Task(memento.getId(), memento.getCommand()));
        } else {
            System.out.println("Nada para desfazer.");
        }
    }
}
