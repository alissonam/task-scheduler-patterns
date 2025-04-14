package com.example.scheduler.model;

import com.example.scheduler.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Task {
    private final String id;
    private final Command command;
}
