package com.example.scheduler.memento;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class TaskHistory {

    private final Stack<TaskMemento> history = new Stack<>();

    public void save(TaskMemento memento) {
        history.push(memento);
    }

    public TaskMemento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }

    public boolean hasUndo() {
        return !history.isEmpty();
    }
}
