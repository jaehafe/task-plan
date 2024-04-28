package com.example.taskplan.event;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<AbstractEvent> events = new ArrayList<>();
    public void add(AbstractEvent event) {
        if(hasScheduleConflictWith(event)) {
            return;
        }
        this.events.add(event);
    }

    public void printAll() {
        events.forEach(Event::print);
    }

    public void printBy(EventType type) {
        events.stream()
                .filter(event -> event.support(type))
                .forEach(Event::print);
    }

    private boolean hasScheduleConflictWith(AbstractEvent event) {
        return events.stream()
                .anyMatch(it ->
                        (event.getStartAt().isBefore(it.getEndAt()) && event.getStartAt().isAfter(it.getStartAt()))
                                || (event.getEndAt().isAfter(it.getStartAt())) && event.getEndAt().isBefore(it.getEndAt()));
    }
}
