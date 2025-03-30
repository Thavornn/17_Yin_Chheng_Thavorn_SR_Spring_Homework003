package org.example.homework_003.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.homework_003.model.entity.Attendee;
import org.example.homework_003.model.entity.dto.request.AttendeeRequest;
import org.example.homework_003.model.response.ApiResponse;
import org.example.homework_003.service.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/attendee")
public class AttendeeController {
        private final AttendeeService attendeeService;


        @Operation (summary = "Get Attendee By Id ")
        @GetMapping("/{attendee-id}")
        public ResponseEntity<ApiResponse<Attendee>>getAttendeeById(@PathVariable("attendee-id") Long attendeeId ){
            Attendee attendee = attendeeService.getAttendeeById(attendeeId);
          ApiResponse<Attendee>response=ApiResponse.<Attendee>builder()
                  .message("Get Attendee By Id is successfully")
                  .payload(attendee)
                  .status(HttpStatus.OK)
                  .timestamp(LocalDateTime.now())
                  .build();
            return ResponseEntity.ok(response);
        }

        @PutMapping("/{attendee_id}")
        public ResponseEntity<ApiResponse<Attendee>>updateAttendeeById(@PathVariable("attendee_id")Long attendeeId,
                                                                       @RequestBody AttendeeRequest request) {
            Attendee attendee = attendeeService.updateAttendeeById(attendeeId, request);
            ApiResponse<Attendee>response=ApiResponse.<Attendee>builder()
                    .message("Update Attendee By Id is successfully")
                    .payload(attendee)
                    .status(HttpStatus.OK)
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.ok(response);

        }

        @DeleteMapping("/{attendee_id}")
        public ResponseEntity<ApiResponse<Attendee>>deleteAttendeeById(@PathVariable("attendee_id") Long attendeeId){
                attendeeService.deleteAttendeeById(attendeeId);
                ApiResponse<Attendee>response=ApiResponse.<Attendee>builder()
                        .message("Update Attendee By Id is successfully")
                        .payload(null)
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build();
            return ResponseEntity.ok(response);

        }

        @GetMapping
        public ResponseEntity<ApiResponse<List<Attendee>>>gettAllAttendee() {
            List<Attendee> attendees = attendeeService.getAllAttendee();
            ApiResponse<List<Attendee>> response = ApiResponse.<List<Attendee>>builder()
                    .message("Update Attendee By Id is successfully")
                    .payload(attendees)
                    .status(HttpStatus.OK)
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.ok(response);
        }

        @PostMapping
        public ResponseEntity<ApiResponse<Attendee>>SaveAttendee(@RequestBody AttendeeRequest request) {
            Attendee attendee = attendeeService.SaveAttendee(request);
            ApiResponse<Attendee> response = ApiResponse.<Attendee>builder()
                    .message("Update Attendee By Id is successfully")
                    .payload(attendee)
                    .status(HttpStatus.OK)
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.ok(response);
        }
}
