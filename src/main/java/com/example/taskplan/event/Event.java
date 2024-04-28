package com.example.taskplan.event;

public interface Event {
    void print();

    boolean support(EventType type);
}
