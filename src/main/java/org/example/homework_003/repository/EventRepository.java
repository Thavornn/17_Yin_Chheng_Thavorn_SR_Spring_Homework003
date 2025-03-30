package org.example.homework_003.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework_003.model.entity.Event;
import org.example.homework_003.model.entity.Venue;
import org.example.homework_003.model.entity.dto.request.EventRequest;
import org.example.homework_003.model.entity.dto.request.VenueRequest;

import java.util.List;

@Mapper
public interface EventRepository {

//still not show all data it onl said success but the payload is not working

    @Results(id="eventMapper", value = {
            @Result(property = "eventId" , column = "event_id"),
            @Result(property = "eventName" , column = "event_name"),
            @Result(property = "eventDate" , column = "event_date"),
            @Result(property = "venue" , column = "venue_id" , one = @One(select = "org.example.homework_003.repository.VenueRepository.getVenueById")),
            @Result(property = "attendee" , column = "event_id" , many = @Many(select = "org.example.homework_003.repository.EventAttendeesRepository.getAllEventAttendeesById"))

    })
    @Select("""
                SELECT * FROM events
                WHERE event_id = #{eventId};
        
            """)
    Event getEventById(Long eventId);



    @ResultMap("eventMapper")
    @Select("""
    UPDATE events SET event_name = #{req.eventName} , event_date = #{req.eventDate} WHERE event_id = #{eventId}
    RETURNING *;
    """)
    Event updateEventById(Long eventId, @Param("req") EventRequest request);



    @ResultMap("eventMapper")
    @Delete("""
        DELETE FROM events 
        WHERE event_id = #{eventId};
""")
    void deleteEventById(Long eventId);



    @ResultMap("eventMapper")
    @Select("""
        SELECT * FROM events;
""")
    List<Event> getAllEvents();


    @ResultMap("eventMapper")
    @Select("""
    INSERT INTO events
    VALUES (default, #{request.eventName}, #{request.event  Date}, #{request.venueId})
    RETURNING *;
""")
    Event saveEvent(@Param("request") EventRequest request);
}


