package org.example.homework_003.controller;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.jdbc.Null;
import org.example.homework_003.model.entity.Venue;
import org.example.homework_003.model.entity.dto.request.VenueRequest;
import org.example.homework_003.model.response.ApiResponse;
import org.example.homework_003.service.Impl.VenueServiceImpl;
import org.example.homework_003.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/venue")
public class VenueController {
    private final VenueService venueService;


//    @GetMapping
//    public ResponseEntity<ApiResponse<List<Venue>>> getAllVenues(){
//        List<Venue> venues = venueService.getAllVenues();
//        ApiResponse<List<Venue>> response = ApiResponse.<List<Venue>>builder()
//                .message("Get All Venues is Successfully")
//                .payload(venueService.getAllVenues())
//                .status(HttpStatus.OK)
//                .timestamp(LocalDateTime.now())
//                .build();
//        return ResponseEntity.ok(response);
//
//    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Venue>>> getAllVenues(){
        List<Venue> venues = venueService.getAllVenues();
        ApiResponse<List<Venue>> response= ApiResponse.<List<Venue>>builder()
                .message("Get All venue is successfully")
                .payload(venues)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
        public ResponseEntity<ApiResponse<Venue>> updateVenueById(@PathVariable("id") Integer venueId ,
                                                                  @RequestBody VenueRequest request){
        Venue venue = venueService.updateVenueById(venueId, request);
        ApiResponse<Venue> response= ApiResponse.<Venue>builder()
                .message("Update All venue is successfully")
                .payload(venue)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);


    }

    @DeleteMapping("/{id}")
        public ResponseEntity<ApiResponse<Venue>>deleteVenueById(@PathVariable("id")Integer venueId){
         Venue venue = venueService.deleteVenueById(venueId);
        ApiResponse<Venue> response= ApiResponse.<Venue>builder()
                .message("Delete All venue is successfully")
                .payload(venue)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<ApiResponse<Venue>> getVenueById(@PathVariable("id")Integer venueId){
        Venue venue = venueService.getVenueById(venueId);
        ApiResponse<Venue> response= ApiResponse.<Venue>builder()
                .success(true)
                .message("Get Venue By ID "+ venueId +" Successfully")
                .status(HttpStatus.OK)
                .payload(venue)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Venue>>saveVenue(@RequestBody VenueRequest request){
        Venue venue= venueService.saveVenue(request);
             ApiResponse<Venue> response= ApiResponse.<Venue>builder()
                .message("Insert Into  venue is successfully")
                .payload(venue)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }








}
