package com.example.scheduler.command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PrintTaskCommand implements Command {

    private final String message;

    @Override
    public void execute() {
        System.out.println("Executando tarefa: " + message);
    }
}
