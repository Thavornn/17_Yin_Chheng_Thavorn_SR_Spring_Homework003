package org.example.homework_003.controller;

import lombok.RequiredArgsConstructor;
import org.example.homework_003.model.entity.Attendee;
import org.example.homework_003.model.entity.Event;
import org.example.homework_003.model.entity.Venue;
import org.example.homework_003.model.entity.dto.request.EventRequest;
import org.example.homework_003.model.entity.dto.request.VenueRequest;
import org.example.homework_003.model.response.ApiResponse;
import org.example.homework_003.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;


    @GetMapping ("/{event_id}")
    public ResponseEntity<ApiResponse<Event>> getEventById(@PathVariable("event_id")Long eventId){
        Event event                                                                                              = eventService.getEventById(eventId);
        ApiResponse<Event> response= ApiResponse.<Event>builder()
                .message("Get Event by Id is successfully")
                .payload(event)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{event_id}")
    public ResponseEntity<ApiResponse<Event>> updateEventById(@PathVariable("event_id") Long eventId ,
                                                              @RequestBody EventRequest request){
        Event event = eventService.updateEventById(eventId, request);
        ApiResponse<Event> response= ApiResponse.<Event>builder()
                .message("Update All Event is successfully")
                .payload(event)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);


    }

    @DeleteMapping("/{event_id}")
    public ResponseEntity<ApiResponse<Event>>deleteEntityById(@PathVariable("event_id")Long eventId){
        Event event = eventService.getEventById(eventId);
        ApiResponse<Event> response= ApiResponse.<Event>builder()
                .message("Delete All Event is successfully")
                .payload(event)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);

    }
    @GetMapping
   public ResponseEntity<ApiResponse<List<Event>>> getAllEvents(){
        List<Event> event = eventService.getAllEvents();
        ApiResponse<List<Event>> response = ApiResponse.<List<Event>>builder()
                .message("Delete All Event is successfully")
                .payload(event)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Event>>saveEvent(@RequestBody EventRequest request){
        Event event = eventService.saveEvent(request);
        ApiResponse<Event> response= ApiResponse.<Event>builder()
                .message("Insert Into  Event is successfully")
                .payload(event)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }



}