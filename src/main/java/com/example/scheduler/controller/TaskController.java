package com.example.scheduler.controller;

import com.example.scheduler.command.PrintTaskCommand;
import com.example.scheduler.dto.TaskRequest;
import com.example.scheduler.model.Task;
import com.example.scheduler.service.TaskScheduler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskScheduler scheduler;

    @PostMapping
    public ResponseEntity<String> scheduleTask(@RequestBody TaskRequest request) {
        Task task = new Task(request.getId(), new PrintTaskCommand(request.getMessage()));
        scheduler.schedule(task);
        return ResponseEntity.ok("Tarefa agendada com sucesso: " + task.getId());
    }

    @PostMapping("/execute")
    public ResponseEntity<String> executeNext() {
        scheduler.runNext();
        return ResponseEntity.ok("Tentativa de execução da próxima tarefa.");
    }
}
