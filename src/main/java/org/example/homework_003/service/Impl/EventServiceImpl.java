package org.example.homework_003.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.homework_003.exception.NotFoundException;
import org.example.homework_003.model.entity.Event;
import org.example.homework_003.model.entity.dto.request.EventRequest;
import org.example.homework_003.repository.EventRepository;
import org.example.homework_003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;


    @Override
    public Event getEventById(Long eventId) {
        if(eventRepository.getEventById(eventId) == null ){
            throw new NotFoundException("Id is null");
        }else
        return eventRepository.getEventById(eventId);
    }


    @Override
    public Event updateEventById(Long eventId, EventRequest request) {
        if(eventRepository.getEventById(eventId) == null ){
            throw new NotFoundException("Id is null");
        }else
        return eventRepository.updateEventById(eventId, request);
    }

    @Override
    public void deleteEventById(Long eventId) {
        if(eventRepository.getEventById(eventId) == null ){
            throw new NotFoundException("Id is null");
        }else
        eventRepository.deleteEventById(eventId);
    }


    @Override
    public Event saveEvent(EventRequest request) {
        if(request == null ){
            throw new NotFoundException("Can not be Null");
        }else
        return eventRepository.saveEvent(request);
    }

    @Override
    public List<Event> getAllEvents(Integer page, Integer size) {
        page = (page - 1) * size;
        return eventRepository.getAllEvents(page, size);
    }
}
