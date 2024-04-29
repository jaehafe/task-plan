package com.example.taskplan;

import com.example.taskplan.event.*;
import com.example.taskplan.event.update.UpdateMeeting;
import com.example.taskplan.reader.EventCsvReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class TaskPlanApplication {

    public static void main(String[] args) throws IOException {
//        List<AbstractEvent> list = new ArrayList<>();
        Schedule schedule = new Schedule();

        EventCsvReader csvReader = new EventCsvReader();
        String meetingCsvPath = "/data/meeting.csv";

        List<Meeting> meetings = csvReader.readMeetings(meetingCsvPath);
        meetings.forEach(schedule::add);
        schedule.printAll();

        Meeting meeting = meetings.get(0);
        meeting.print();

        System.out.println("수정 후...");

        meeting.validateAndUpdate(
                new UpdateMeeting(
                        "new title",
                        ZonedDateTime.now(),
                        ZonedDateTime.now().plusHours(1),
                        null,
                        "A",
                        "new agenda"
                )
        );

        meeting.delete(true);

        System.out.println("삭제 후 수정...");

        meeting.validateAndUpdate(
                new UpdateMeeting(
                        "new title 2",
                        ZonedDateTime.now(),
                        ZonedDateTime.now().plusHours(1),
                        null,
                        "2",
                        "new agenda 2"
                )
        );

        meeting.print();
    }
}
