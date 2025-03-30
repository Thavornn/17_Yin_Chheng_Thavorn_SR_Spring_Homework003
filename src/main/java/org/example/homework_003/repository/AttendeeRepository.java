package org.example.homework_003.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework_003.model.entity.Attendee;
import org.example.homework_003.model.entity.dto.request.AttendeeRequest;
import org.example.homework_003.model.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Mapper
public interface AttendeeRepository {

    @Results(id = "attMapper" , value = {
        @Result(property = "attendeeId" , column = "attendee_id"),
        @Result(property = "attendeeName" , column = "attendee_name")

    })

//    @ResultMap("attendeeMapper")
    @Select("""
        SELECT * FROM attendees
        WHERE attendee_id = #{attendeeId};
""")
    Attendee getAttendeeById(Long attendeeId);

    @ResultMap("attMapper")
    @Select("""
        UPDATE attendees
        SET attendee_name = #{req.attendeeName}, email = #{req.email}
        WHERE attendee_id = #{attendeeId}
        RETURNING *;

""")
    Attendee updateAttendeeById( Long attendeeId, @Param("req")AttendeeRequest request );

    @ResultMap("attMapper")
    @Delete(""" 
        DELETE FROM attendees
        WHERE attendee_id = #{attendee_id};  

""")
    void deleteAttendeeById(@Param("attendee_id")Long attendeeId);

    @ResultMap("attMapper")
    @Select("""
        SELECT * FROM attendees OFFSET (#{offset}, #{limit});
""")
    List<Attendee> getAllAttendee(@Param("offser") Integer page, @Param("limit") Integer size);


    @ResultMap("attMapper")
    @Select("""
        INSERT INTO attendees VALUES (default, #{req.attendeeName}, #{req.email} )
        RETURNING *;
""")
    Attendee saveAttendee(@Param("req") AttendeeRequest request);
}




