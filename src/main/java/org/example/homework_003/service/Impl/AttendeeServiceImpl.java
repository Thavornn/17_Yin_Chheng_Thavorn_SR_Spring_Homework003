package org.example.homework_003.service.Impl;

import org.example.homework_003.exception.NotFoundException;
import org.example.homework_003.model.entity.Attendee;
import org.example.homework_003.model.entity.dto.request.AttendeeRequest;
import org.example.homework_003.repository.AttendeeRepository;
import org.example.homework_003.service.AttendeeService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AttendeeServiceImpl implements AttendeeService {
    private final AttendeeRepository attendeeRepository;

    public AttendeeServiceImpl(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public Attendee getAttendeeById(Long attendeeId) {
        if(attendeeRepository.getAttendeeById(attendeeId) == null ){
            throw new NotFoundException("Id is null");
        }else
        return attendeeRepository.getAttendeeById(attendeeId);
    }

    @Override
    public Attendee updateAttendeeById(Long attendeeId, AttendeeRequest request) {
        if(attendeeRepository.getAttendeeById(attendeeId) == null ){
            throw new NotFoundException("Id is null");
        }else
        return attendeeRepository.updateAttendeeById(attendeeId, request);
    }

    @Override
    public void deleteAttendeeById(Long attendeeId) {
        if(attendeeRepository.getAttendeeById(attendeeId) == null ){
            throw new NotFoundException("Id is null");
        }else
         attendeeRepository.deleteAttendeeById(attendeeId);
    }

    @Override
    public List<Attendee> getAllAttendee() {
        return attendeeRepository.getAllAttendee();
    }

    @Override
    public Attendee SaveAttendee(AttendeeRequest request) {
        if(request == null ){
            throw new NotFoundException("Can not be Null");
        }else
        return attendeeRepository.saveAttendee(request);
    }


}
