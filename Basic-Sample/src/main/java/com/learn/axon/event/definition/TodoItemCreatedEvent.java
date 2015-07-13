package com.learn.axon.event.definition;

/**
 * Created by gabbi on 09/07/15.
 */
public class TodoItemCreatedEvent {
    private final String todoId;
    private final String description;

    public TodoItemCreatedEvent(String todoId, String description) {
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
