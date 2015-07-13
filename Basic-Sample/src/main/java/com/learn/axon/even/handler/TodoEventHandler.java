package com.learn.axon.even.handler;

import com.learn.axon.event.definition.TodoItemCompletedEvent;
import com.learn.axon.event.definition.TodoItemCreatedEvent;
import org.axonframework.eventhandling.annotation.EventHandler;

/**
 * Created by gabbi on 09/07/15.
 */
public class TodoEventHandler {
    @EventHandler
    public void handle(TodoItemCreatedEvent itemCreatedEvent){
        System.out.println("created " + itemCreatedEvent.getTodoId() + " " + itemCreatedEvent.getDescription());
    }

    @EventHandler
    public void handle(TodoItemCompletedEvent itemCompletedEvent){
        System.out.println(itemCompletedEvent + " completed");
    }
}
