package com.learn.axon.bootstrap;

import com.learn.axon.command.CreateTodoItemCommand;
import com.learn.axon.command.MarkCompletedCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * Created by gabbi on 09/07/15.
 */
public class Runner {
    private final CommandGateway commandGateway;

    public Runner(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("sampleContext.xml");
        Runner runner = new Runner(applicationContext.getBean(CommandGateway.class));
        runner.run();
    }

    private void run() {
        String todoItemId = UUID.randomUUID().toString();
        commandGateway.send(new CreateTodoItemCommand(todoItemId, "sample id"));
        commandGateway.send(new MarkCompletedCommand(todoItemId));
    }
}
