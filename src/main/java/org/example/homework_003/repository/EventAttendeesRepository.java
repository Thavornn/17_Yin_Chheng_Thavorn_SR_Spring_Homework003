package org.example.homework_003.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.homework_003.model.entity.Attendee;

import java.util.List;

@Mapper
public interface EventAttendeesRepository {

    @Select("""
SELECT * FROM event_attendee sc INNER JOIN attendees a  
    ON sc.attendees_id = 
       a.attendee_id WHERE event_id = #{attendee_id};
""")
    List<Attendee> getAllEventAttendeesById (Integer attendee_id);

}
