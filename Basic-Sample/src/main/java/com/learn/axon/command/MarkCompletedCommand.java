package com.learn.axon.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by gabbi on 09/07/15.
 */
public class MarkCompletedCommand {
    @TargetAggregateIdentifier
    private final String todoId;

    public MarkCompletedCommand(String todoId) {
        this.todoId = todoId;
    }

    public String getTodoId() {
        return todoId;
    }
}
