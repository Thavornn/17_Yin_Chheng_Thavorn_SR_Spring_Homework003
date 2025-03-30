package org.example.homework_003.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework_003.model.entity.Venue;
import org.example.homework_003.model.entity.dto.request.VenueRequest;

import java.util.List;

@Mapper
public interface VenueRepository {


    @Select ("""
        SELECT  * FROM venues;
""")
    @Results(id="VenueMapper", value = {
            @Result(property = "venueId" , column = "venue_id"),


    })
    List<Venue> getAllVenues();


    @ResultMap("VenueMapper")
    @Select("""
    UPDATE venues SET venue_name = #{req.venueName} , location = #{req.location} WHERE venue_id = #{venueId}
    RETURNING *;
    """)
    Venue updateVenueById(Integer venueId, @Param("req")VenueRequest request);

    @ResultMap("VenueMapper")
    @Delete("""
        DELETE FROM venues
        WHERE venue_id = #{venueId};
""")
    Venue deleteVenueById(Integer venueId);


    @ResultMap("VenueMapper")
    @Select("""
        SELECT * FROM venues
        WHERE venue_id = #{venueId};
""")
    Venue getVenueById(Integer venueId);

    @ResultMap("VenueMapper")
    @Select("""
    INSERT INTO venues
    VALUES (default, #{request.venueName}, #{request.location})
    RETURNING *;
""")
    Venue saveVenue(@Param("request") VenueRequest request);
}

//        @Delete("""
//            DELETE FROM venues
//            WHERE venue_id = #{venue_id};
//""")
//void


