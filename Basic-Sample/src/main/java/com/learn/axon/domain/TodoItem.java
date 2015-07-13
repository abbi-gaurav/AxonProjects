package com.learn.axon.domain;

import com.learn.axon.command.CreateTodoItemCommand;
import com.learn.axon.command.MarkCompletedCommand;
import com.learn.axon.event.definition.TodoItemCompletedEvent;
import com.learn.axon.event.definition.TodoItemCreatedEvent;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

/**
 * Created by gabbi on 09/07/15.
 */
public class TodoItem extends AbstractAnnotatedAggregateRoot<String>{
    @AggregateIdentifier
    private String id;

    public TodoItem(){}

    @CommandHandler
    public TodoItem(CreateTodoItemCommand createTodoItemCommand){
        apply(new TodoItemCreatedEvent(createTodoItemCommand.getTodoId(), createTodoItemCommand.getDescription()));
    }

    @EventHandler
    public void on(TodoItemCreatedEvent itemCreatedEvent){
        this.id = itemCreatedEvent.getTodoId();
    }

    @CommandHandler
    public void markCompleted(MarkCompletedCommand markCompletedCommand){
        apply(new TodoItemCompletedEvent(id));
    }
}
