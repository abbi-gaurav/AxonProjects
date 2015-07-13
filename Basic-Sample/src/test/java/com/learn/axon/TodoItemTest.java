package com.learn.axon;

import com.learn.axon.command.CreateTodoItemCommand;
import com.learn.axon.command.MarkCompletedCommand;
import com.learn.axon.domain.TodoItem;
import com.learn.axon.event.definition.TodoItemCompletedEvent;
import com.learn.axon.event.definition.TodoItemCreatedEvent;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Test;

/**
 * Created by gabbi on 09/07/15.
 */
public class TodoItemTest {
    private final FixtureConfiguration<TodoItem> fixtureConfiguration = Fixtures.newGivenWhenThenFixture(TodoItem.class);

    @Test
    public void testCreateTodoItem() {
        fixtureConfiguration.given()
                .when(new CreateTodoItemCommand("todo1", "todo1"))
                .expectEvents(new TodoItemCreatedEvent("todo1", "todo1"));
    }

    @Test
    public void testMarkComplete(){
        fixtureConfiguration.given(new TodoItemCreatedEvent("todo1", "todo1"))
                .when(new MarkCompletedCommand("todo1"))
                .expectEvents(new TodoItemCompletedEvent("todo1"));
    }
}
