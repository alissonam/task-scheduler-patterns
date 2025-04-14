package com.example.scheduler.memento;

import com.example.scheduler.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskMemento {
    private final String id;
    private final Command command;
}
