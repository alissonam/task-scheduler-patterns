package com.example.scheduler;

import com.example.scheduler.command.PrintTaskCommand;
import com.example.scheduler.model.Task;
import com.example.scheduler.service.TaskScheduler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(TaskScheduler scheduler) {
		return args -> {
			scheduler.schedule(new Task("1", new PrintTaskCommand("Tarefa 1")));
			scheduler.schedule(new Task("2", new PrintTaskCommand("Tarefa 2")));

			scheduler.runNext();
			scheduler.runNext();
			scheduler.runNext(); // fila vazia
		};
	}
}
