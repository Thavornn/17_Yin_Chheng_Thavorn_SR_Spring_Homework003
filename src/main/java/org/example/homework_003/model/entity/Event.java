package org.example.homework_003.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Event {
        private Long eventId;
        private String eventName;
        private Timestamp eventDate;
        private Venue venue;
        private List <Attendee> attendee;

}
