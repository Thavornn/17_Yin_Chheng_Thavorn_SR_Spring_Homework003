package org.example.homework_003.model.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.homework_003.model.entity.Venue;
import org.w3c.dom.stylesheets.LinkStyle;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    private String eventName;
    private Timestamp eventDate;
    private Long venueId;
    private List<Long> attendeesId;

}
