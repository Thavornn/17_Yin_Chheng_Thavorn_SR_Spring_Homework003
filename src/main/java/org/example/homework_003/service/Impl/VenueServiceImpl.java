package org.example.homework_003.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.homework_003.exception.NotFoundException;
import org.example.homework_003.model.entity.Venue;
import org.example.homework_003.model.entity.dto.request.VenueRequest;
import org.example.homework_003.repository.VenueRepository;
import org.example.homework_003.service.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class VenueServiceImpl implements VenueService {
    private final VenueRepository venueRepository;

    @Override
    public Venue updateVenueById(Integer venueId, VenueRequest request) {
        if(venueRepository.getVenueById(venueId) == null ){
            throw new NotFoundException("Id is null");
        }else
        return venueRepository.updateVenueById(venueId, request);
    }

    @Override
    public List<Venue> getAllVenues() {
        return venueRepository.getAllVenues();
    }

    @Override
    public Venue deleteVenueById(Integer venueId) {
        if(venueRepository.getVenueById(venueId) == null ){
            throw new NotFoundException("Id is null");
        }else
        return venueRepository.deleteVenueById(venueId);
    }

    @Override
    public Venue getVenueById(Integer venueId) {
        if(venueRepository.getVenueById(venueId) == null ){
            throw new NotFoundException("Id is null");
        }else
        return venueRepository.getVenueById(venueId);
    }



    @Override
    public Venue saveVenue(VenueRequest request) {
        if(request == null ){
            throw new NotFoundException("Can not be Null");
        }else
        return venueRepository.saveVenue(request);
    }
}
