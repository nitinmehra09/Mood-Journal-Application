package com.moodjournal.controller;

import com.moodjournal.apiResponse.WeatherResponse;
import com.moodjournal.entities.User;
import com.moodjournal.service.UserLoginService;
import com.moodjournal.service.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private WeatherServices weatherServices;

    @PostMapping()
    public void CreateUser(@RequestBody User user){
        userLoginService.saveNewUser(user);
    }

//    @GetMapping("/city/{city}")
//    public ResponseEntity<?> weatherNow(@PathVariable String city){
//        WeatherResponse response = weatherServices.getWeather(city);
//        return new ResponseEntity<>("HI weather feels like - "+response.getCurrent().getFeelslikeC(), HttpStatus.OK);
//    }

    @GetMapping("/city/{city}")
    public ResponseEntity<WeatherResponse> weatherNow(@PathVariable String city){
        return ResponseEntity.ok(weatherServices.getWeather(city));
    }

}
