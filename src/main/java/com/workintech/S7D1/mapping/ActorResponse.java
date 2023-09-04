package com.workintech.S7D1.mapping;

import com.workintech.S7D1.entity.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorResponse {
    private int movieId;

    private String firstName;

    private String lastName;

    private Gender gender;

    private LocalDate birthDate;
}
