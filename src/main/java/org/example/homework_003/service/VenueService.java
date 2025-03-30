package org.example.homework_003.service;

import org.example.homework_003.model.entity.Venue;
import org.example.homework_003.model.entity.dto.request.VenueRequest;

import java.util.List;

public interface VenueService {


      Venue updateVenueById(Integer venueId, VenueRequest request);

   ;


      List<Venue> getAllVenues();

    Venue deleteVenueById(Integer venueId);

    Venue getVenueById(Integer venueId);

    Venue saveVenue(VenueRequest request);
}
