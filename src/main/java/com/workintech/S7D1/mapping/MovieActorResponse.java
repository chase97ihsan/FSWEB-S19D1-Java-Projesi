package com.workintech.S7D1.mapping;

import com.workintech.S7D1.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieActorResponse {

    private Movie movie;
    private int actorId;
    private String actorFirstName;
    private String actorLastName;
    private LocalDate actorBirthDate;

}
