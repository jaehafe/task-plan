package com.example.taskplan.event;

import java.time.ZonedDateTime;

public class Todo extends AbstractEvent {

    private String description;

    public Todo(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt, String description) {
        super(id, title, startAt, endAt);
        thid.description = description;
    }

    @Override
    public void print() {
        System.out.printf("할 일", getTitle(), description);
    }
}
