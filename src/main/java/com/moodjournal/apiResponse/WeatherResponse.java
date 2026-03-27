package com.moodjournal.apiResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse {

    private Current current;

    @Getter
    @Setter
    public static class Current {

        private int humidity;
        private int cloud;

        @JsonProperty("feelslike_c")
        private double feelslikeC;

        @JsonProperty("feelslike_f")
        private double feelslikeF;
    }
}