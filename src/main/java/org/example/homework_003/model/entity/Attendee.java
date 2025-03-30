package org.example.homework_003.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendee {
    private Long attendee_id;
    private String attendee_name;
    private String email;
}

