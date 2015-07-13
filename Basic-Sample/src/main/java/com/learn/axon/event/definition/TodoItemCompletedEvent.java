package com.learn.axon.event.definition;

/**
 * Created by gabbi on 09/07/15.
 */
public class TodoItemCompletedEvent {
    private final String todoId;

    public TodoItemCompletedEvent(String todoId) {
        this.todoId = todoId;
    }

    public String getTodoId() {
        return todoId;
    }
}
