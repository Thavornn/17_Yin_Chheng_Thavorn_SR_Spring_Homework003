package org.example.homework_003.service;

import org.example.homework_003.model.entity.Event;
import org.example.homework_003.model.entity.dto.request.EventRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService  {



    Event getEventById(Long eventId);

    Event updateEventById(Long eventId, EventRequest request);

    void deleteEventById(Long eventId);



    Event saveEvent(EventRequest request);

    List<Event> getAllEvents(Integer page, Integer size);
}
