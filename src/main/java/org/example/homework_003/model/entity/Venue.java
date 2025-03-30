package org.example.homework_003.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venue      {
    private Integer venueId;
    private  String venue_name;
    private String location;

}
