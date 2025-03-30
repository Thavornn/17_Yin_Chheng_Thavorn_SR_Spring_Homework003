package org.example.homework_003.service;

import org.example.homework_003.model.entity.Attendee;
import org.example.homework_003.model.entity.dto.request.AttendeeRequest;

import java.util.List;

public interface AttendeeService {
     Attendee getAttendeeById(Long attendeeId) ;




    Attendee updateAttendeeById(Long attendeeId, AttendeeRequest request);

    void deleteAttendeeById(Long attendeeId);

    List<Attendee> getAllAttendee();

    Attendee SaveAttendee(AttendeeRequest request);
}
