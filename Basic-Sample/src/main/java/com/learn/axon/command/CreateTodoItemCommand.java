package com.learn.axon.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by gabbi on 09/07/15.
 */
public class CreateTodoItemCommand {
    @TargetAggregateIdentifier
    private final String todoId;

    private final String description;

    public CreateTodoItemCommand(String todoId, String description) {
        this.todoId = todoId;
        this.description = description;
    }

    public String getTodoId() {
        return todoId;
    }

    public String getDescription() {
        return description;
    }
}
