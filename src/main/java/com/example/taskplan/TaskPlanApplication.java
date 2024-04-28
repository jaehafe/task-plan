package com.example.taskplan;

import com.example.taskplan.event.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class TaskPlanApplication {

    public static void main(String[] args) {
//        List<AbstractEvent> list = new ArrayList<>();
        Schedule schedule = new Schedule();
        HashSet<String> participants = new HashSet<>();
        participants.add("jaeha");

        Meeting meeting1 = new Meeting(
                1,
                "meeting1",
                ZonedDateTime.now(),
                ZonedDateTime.now().plusHours(1),
                participants,
                "meetingRoomA",
                "스터디"
        );
        schedule.add(meeting1);

        Todo todo1 = new Todo(
                2,
                "todo1",
                ZonedDateTime.now().plusHours(3),
                ZonedDateTime.now().plusHours(4),
                "할 일"
        );
        Todo todo2 = new Todo(
                3,
                "todo2",
                ZonedDateTime.now().plusHours(4),
                ZonedDateTime.now().plusHours(5),
                "할 일"
        );
        schedule.add(todo1);

        schedule.printAll();

        schedule.printBy(EventType.TO_DO);

    }
}
